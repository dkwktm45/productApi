package com.zerobase.domain.repository;

import com.zerobase.domain.entity.ProductInfo;
import com.zerobase.domain.entity.ProductOrg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo,
    Long> {
  List<ProductInfo> findByProductOrg(ProductOrg productOrg);


}
