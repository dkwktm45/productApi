package com.zerobase.productapi.service;

import com.zerobase.productapi.config.encrypt.Encrypt;
import com.zerobase.productapi.dto.RequestUser;
import com.zerobase.productapi.entity.UserInfo;
import com.zerobase.productapi.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserInfoRepository userInfoRepository;
  public void saveUser(RequestUser requestUser) {
    userInfoRepository.save(UserInfo.builder()
        .usrAmount(requestUser.getUserIncomeAmount())
        .usrName(requestUser.getUserName())
        .usrKey(UUID.randomUUID().toString())
        .usrRegNumber(requestUser.getUserRegistrationNumber())
        .build());
  }

}
