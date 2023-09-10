package com.zerobase.productapi.dto;

import com.zerobase.productapi.config.encrypt.Encrypt;
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
