package com.zerobase.productapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfo {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String usrKey;
  private String usrRegNumber;
  private String usrName;
  private String usrAmount;
}
