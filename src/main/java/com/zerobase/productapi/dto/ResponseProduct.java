package com.zerobase.productapi.dto;

import com.zerobase.productapi.dto.Type.OrgCode;
import com.zerobase.productapi.dto.Type.ProductCode;
import com.zerobase.productapi.entity.ProductInfo;
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
