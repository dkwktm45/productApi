package com.zerobase.domain.type;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum OrgCode {
  RANKINGDAK("랭킹닭컴"),
  ORION("닥터유"),
  METREE("미트리");

  private final String value;
  OrgCode(String code) {
    this.value = code;
  }
  public static OrgCode getCode(String data) {
    return Arrays.stream(OrgCode.values())
        .filter(i -> i.getValue().equals(data))
        .findAny()
        .orElseThrow(() -> new NullPointerException("존재하지 않는 조직입니다."));
  }
}
