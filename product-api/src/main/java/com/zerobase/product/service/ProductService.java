package com.zerobase.product.service;

import com.zerobase.domain.entity.ProductInfo;
import com.zerobase.domain.entity.ProductOrg;
import com.zerobase.domain.repository.ProductInfoRepository;
import com.zerobase.domain.repository.ProductOrgRepository;
import com.zerobase.domain.type.OrgCode;
import com.zerobase.product.dto.RequestProduct;
import com.zerobase.product.dto.ResponseCommon;
import com.zerobase.product.dto.ResponseProduct;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
  private final ProductInfoRepository productInfoRepository;
  protected final ProductOrgRepository productOrgRepository;
  private final EntityManager em;
  private final CacheManager cacheManager;

  @Cacheable(value = "product", key = "#orgCd.name()")
  public List<ResponseProduct> getList(OrgCode orgCd) {
    List<ProductInfo> productInfos = productInfoRepository.findByProductOrg(
        productOrgRepository.findByOrgCd(orgCd)
            .orElseThrow(() -> new NullPointerException("값을 찾지 못하고 있습니다.")));

    return productInfos.stream().map(i -> new ResponseProduct(i)).collect(Collectors.toList());
  }
  @Transactional
  public ResponseCommon saveProduct(RequestProduct requestProduct) {
    String sqlProductinfo = "SELECT p FROM ProductInfo p WHERE p.prodNm = " +
        ":prodNm AND p.prodCd = :prodCd";
    List<ProductInfo> prod = em.createQuery(sqlProductinfo,
            ProductInfo.class)
        .setParameter("prodNm", requestProduct.getProdNm())
        .setParameter("prodCd", requestProduct.getProdCd()).getResultList();
    String jpql = "SELECT p FROM ProductOrg p WHERE p.orgCd = :orgCd";
    List<ProductOrg> org = em.createQuery(jpql, ProductOrg.class)
        .setParameter("orgCd", requestProduct.getOrgCd()).getResultList();

    if (!prod.isEmpty() && !org.isEmpty()) {
      persistAndDeleteCacheInfo(requestProduct, prod.get(0));
    } else if (!org.isEmpty()) {
      persistAndDeleteCacheOrg(requestProduct, org.get(0));
    } else {
      // 둘다 없는 경우
      ProductOrg productOrg = ProductOrg.builder()
          .orgCd(requestProduct.getOrgCd())
          .productInfos(new ArrayList<>())
          .build();

      ProductInfo newProductInfo = ProductInfo.builder()
          .prodCd(requestProduct.getProdCd())
          .productOrg(productOrg)
          .prodMaxIntr(requestProduct.getProdMaxIntr())
          .prodMinIntr(requestProduct.getProdMinIntr())
          .prodNm(requestProduct.getProdNm())
          .build();
      productOrg.addNewProduct(newProductInfo);
      productInfoRepository.save(newProductInfo);
      productOrgRepository.save(productOrg);
    }
    return ResponseCommon.builder()
        .responseCode("200")
        .message("success").build();
  }

  @Transactional
  public void persistAndDeleteCacheOrg(RequestProduct requestProduct,
                           ProductOrg productOrg) {
    ProductInfo newProductInfo = ProductInfo.builder()
        .prodCd(requestProduct.getProdCd())
        .productOrg(productOrg)
        .prodMaxIntr(requestProduct.getProdMaxIntr())
        .prodMinIntr(requestProduct.getProdMinIntr())
        .prodNm(requestProduct.getProdNm())
        .build();
    productOrg.addNewProduct(newProductInfo);
    evictSingleCacheValue("product", requestProduct.getOrgCd().name());
  }

  @Transactional
  public void persistAndDeleteCacheInfo(RequestProduct requestProduct,
                               ProductInfo productInfo) {
    em.persist(productInfo);
    productInfo.resetProduct(requestProduct.getProdNm(),
        requestProduct.getProdMinIntr(),requestProduct.getProdMaxIntr());
    evictSingleCacheValue("product", requestProduct.getOrgCd().name());
  }
  public void evictSingleCacheValue(String cacheName, String cacheKey) {
    cacheManager.getCache(cacheName).evict(cacheKey);
  }
}
