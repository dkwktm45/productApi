package com.zerobase.productapi.repository;

import com.zerobase.productapi.dto.Type.OrgCode;
import com.zerobase.productapi.entity.ProductOrg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductOrgRepository extends JpaRepository<ProductOrg,Long> {

  Optional<ProductOrg> findByOrgCd(OrgCode orgCd);
}
