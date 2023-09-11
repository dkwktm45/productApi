package com.zerobase.product.error;

import com.zerobase.product.error.type.ProductErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductException extends RuntimeException {
  private ProductErrorCode productErrorCode;
  private String errorMessage;

  public ProductException(ProductErrorCode productErrorCode) {
    this.productErrorCode = productErrorCode;
    this.errorMessage = productErrorCode.getDescription();
  }
}
