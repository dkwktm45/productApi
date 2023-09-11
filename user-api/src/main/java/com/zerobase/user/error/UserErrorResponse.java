package com.zerobase.user.error;

import com.zerobase.user.error.type.UserErrorCode;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserErrorResponse {
  private UserErrorCode userErrorCode;
  private String name;
}

