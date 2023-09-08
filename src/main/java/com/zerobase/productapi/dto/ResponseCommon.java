package com.zerobase.productapi.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class ResponseCommon {
  private String responseCode;
  private String message;
}
