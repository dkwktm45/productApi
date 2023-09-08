package com.zerobase.productapi.dto.Type;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ProductCode{
  FOOD("닭가슴살"),
  EQUIPMENT("스트랩"),
  NUTRITIONAL("오메가3");

  private final String  value;
  ProductCode(String code) {
    this.value = code;
  }
  public static ProductCode getCode(String data) {
    return Arrays.stream(ProductCode.values())
        .filter(i -> i.getValue().equals(data))
        .findAny()
        .orElseThrow(() -> new NullPointerException("존재하지 않는 조직입니다."));
  }
}
