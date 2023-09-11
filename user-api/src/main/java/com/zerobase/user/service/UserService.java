package com.zerobase.user.service;


import com.zerobase.domain.entity.UserInfo;
import com.zerobase.domain.repository.UserInfoRepository;
import com.zerobase.user.dto.RequestUser;
import com.zerobase.user.dto.ResponseUser;
import com.zerobase.user.error.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.zerobase.user.error.type.UserErrorCode.USER_EXISTS;
import static com.zerobase.user.error.type.UserErrorCode.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserInfoRepository userInfoRepository;
  public String saveUser(RequestUser requestUser) {
    if (userCheck(requestUser.getUserRegistrationNumber())) {
      throw new UserException(USER_EXISTS);
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
        .orElseThrow(() -> new UserException(USER_NOT_FOUND));
    return ResponseUser.builder()
        .userRegistrationNumber(userInfo.getUsrRegNumber())
        .userKey(userKey).build();
  }
}
