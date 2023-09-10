package com.zerobase.domain.entity;

import com.zerobase.domain.converter.OrgConverter;
import com.zerobase.domain.type.OrgCode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductOrg {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long orgId;

  @Convert(converter = OrgConverter.class)
  private OrgCode orgCd;

  @OneToMany(mappedBy = "productOrg" ,cascade = CascadeType.PERSIST)
  private List<ProductInfo> productInfos = new ArrayList<>();

  public void addNewProduct(ProductInfo newProductInfo) {
    this.productInfos.add(newProductInfo);
  }
}
