package com.zerobase.product.error;

import com.zerobase.product.error.type.ProductErrorCode;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductErrorResponse {
  private ProductErrorCode productErrorCode;
  private String name;
}
