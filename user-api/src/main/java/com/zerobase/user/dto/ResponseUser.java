package com.zerobase.user.dto;

import com.zerobase.user.encrypt.Encrypt;
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
