package com.zerobase.productapi.repository;

import com.zerobase.productapi.dto.Type.ProductCode;
import com.zerobase.productapi.entity.ProductInfo;
import com.zerobase.productapi.entity.ProductOrg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo,
    Long> {
  List<ProductInfo> findByProductOrg(ProductOrg productOrg);


}
