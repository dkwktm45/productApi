package com.zerobase.product.dto;

import com.zerobase.domain.entity.ProductInfo;
import com.zerobase.domain.type.OrgCode;
import com.zerobase.domain.type.ProductCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseProduct {
  private OrgCode orgCd;
  private ProductCode prodCd;
  private String prodNm;
  private String prodMinIntr;
  private String prodMaxIntr;

  public ResponseProduct(ProductInfo productInfo) {
    this.orgCd = productInfo.getProductOrg().getOrgCd();
    this.prodCd = productInfo.getProdCd();
    this.prodNm = productInfo.getProdNm();
    this.prodMinIntr = productInfo.getProdMinIntr();
    this.prodMaxIntr = productInfo.getProdMaxIntr();
  }
}
