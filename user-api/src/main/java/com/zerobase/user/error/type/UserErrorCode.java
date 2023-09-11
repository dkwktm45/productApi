package com.zerobase.user.error.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserErrorCode {
  TYPE_MISMATCH("잘못된 요청입니다."),
  USER_NOT_FOUND("사용자를 찾을 수 없습니다."),
  USER_EXISTS("이미 존재하는 회원입니다.");

  private final String description;
}

