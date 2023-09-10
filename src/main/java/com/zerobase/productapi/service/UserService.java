package com.zerobase.productapi.service;

import com.zerobase.productapi.dto.RequestUser;
import com.zerobase.productapi.dto.ResponseUser;
import com.zerobase.productapi.entity.UserInfo;
import com.zerobase.productapi.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserInfoRepository userInfoRepository;
  public String saveUser(RequestUser requestUser) {
    if (userCheck(requestUser.getUserRegistrationNumber())) {
      throw new RuntimeException("존재하는 회원입니다.");
    }

    return userInfoRepository.save(UserInfo.builder()
        .usrAmount(requestUser.getUserIncomeAmount())
        .usrName(requestUser.getUserName())
        .usrKey(UUID.randomUUID().toString())
        .usrRegNumber(requestUser.getUserRegistrationNumber())
        .build()).getUsrKey();
  }
  public boolean userCheck(String usrRegNumber) {
    return userInfoRepository.existsByUsrRegNumber(usrRegNumber);
  }

  public ResponseUser findUser(String userKey) {
    UserInfo userInfo = userInfoRepository.findByUsrKey(userKey)
        .orElseThrow(() -> new RuntimeException("존재하지 않는 회원입니다."));
    return ResponseUser.builder()
        .userRegistrationNumber(userInfo.getUsrRegNumber())
        .userKey(userKey).build();
  }
}
