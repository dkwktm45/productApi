package com.zerobase.productapi.dto;

import com.zerobase.productapi.config.encrypt.Encrypt;
import lombok.*;

@Getter
@Setter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUser {
  public String userKey;
  @Encrypt
  public String userRegistrationNumber;
}
