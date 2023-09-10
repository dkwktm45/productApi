package com.zerobase.domain.entity;

import com.zerobase.domain.converter.ProductConverter;
import com.zerobase.domain.type.ProductCode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Builder
public class ProductInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long productId;

  @ManyToOne
  @JoinColumn(name = "org_id")
  private ProductOrg productOrg;

  @Convert(converter = ProductConverter.class)
  private ProductCode prodCd;

  private String prodNm;

  private String prodMinIntr;

  private String prodMaxIntr;

  public void resetProduct(String prodNm, String prodMinIntr,String prodMaxIntr){
    this.prodNm = prodNm;
    this.prodMaxIntr = prodMaxIntr;
    this.prodMinIntr = prodMinIntr;
  }
}
