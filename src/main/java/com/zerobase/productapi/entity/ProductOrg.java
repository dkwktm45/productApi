package com.zerobase.productapi.entity;

import com.zerobase.productapi.dto.Type.OrgCode;
import com.zerobase.productapi.dto.converter.OrgConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity @Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductOrg {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "org_id")
  private long orgId;

  @Convert(converter = OrgConverter.class)
  private OrgCode orgCd;

  @OneToMany(mappedBy = "productOrg" ,cascade = CascadeType.PERSIST)
  private List<ProductInfo> productInfos = new ArrayList<>();

  public void addNewProduct(ProductInfo newProductInfo) {
    this.productInfos.add(newProductInfo);
  }
}
