package com.zerobase.productapi.entity;

import com.zerobase.productapi.dto.RequestProduct;
import com.zerobase.productapi.dto.Type.ProductCode;
import com.zerobase.productapi.dto.converter.ProductConverter;
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

  public void resetProduct(RequestProduct requestProduct){
    this.prodNm = requestProduct.getProdNm();
    this.prodMaxIntr = requestProduct.getProdMaxIntr();
    this.prodMinIntr = requestProduct.getProdMinIntr();
  }
}
