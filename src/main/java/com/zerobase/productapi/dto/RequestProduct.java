package com.zerobase.productapi.dto;

import com.zerobase.productapi.dto.Type.OrgCode;
import com.zerobase.productapi.dto.Type.ProductCode;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestProduct {
  private OrgCode orgCd;
  private ProductCode prodCd;
  private String prodNm;
  private String prodMinIntr;
  private String prodMaxIntr;
}
