package com.zerobase.product.dto;


import com.zerobase.domain.type.OrgCode;
import com.zerobase.domain.type.ProductCode;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class RequestProduct {
  private OrgCode orgCd;
  private ProductCode prodCd;
  private String prodNm;
  private String prodMinIntr;
  private String prodMaxIntr;
}
