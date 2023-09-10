package com.zerobase.user.dto;

import com.zerobase.user.encrypt.Encrypt;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class RequestUser {
  @Encrypt
  private String userIncomeAmount;
  private String userName;
  @Encrypt
  private String userRegistrationNumber;
}
