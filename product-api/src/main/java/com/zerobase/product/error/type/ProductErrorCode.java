package com.zerobase.product.error.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductErrorCode {

  TYPE_MISMATCH("잘못된 요청입니다."),
  PRODUCT_NOT_FOUND("사용자를 찾을 수 없습니다.");

  private final String description;
}
