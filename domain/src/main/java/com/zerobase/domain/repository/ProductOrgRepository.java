package com.zerobase.domain.repository;

import com.zerobase.domain.entity.ProductOrg;
import com.zerobase.domain.type.OrgCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductOrgRepository extends JpaRepository<ProductOrg,
    Long> {

  Optional<ProductOrg> findByOrgCd(OrgCode orgCd);
}
