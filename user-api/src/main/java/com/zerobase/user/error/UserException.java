package com.zerobase.user.error;

import com.zerobase.user.error.type.UserErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserException extends RuntimeException{
  private UserErrorCode userErrorCode;
  private String errorMessage;

  public UserException(UserErrorCode userErrorCode) {
    this.userErrorCode = userErrorCode;
    this.errorMessage = userErrorCode.getDescription();
  }
}
