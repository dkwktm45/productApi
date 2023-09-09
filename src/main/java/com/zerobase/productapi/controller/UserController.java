package com.zerobase.productapi.controller;

import com.zerobase.productapi.dto.RequestUser;
import com.zerobase.productapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("fintech/v1/user")
public class UserController {
  private final UserService userService;

  @PostMapping("/information")
  public void reqUserInfo(
      @RequestBody RequestUser requestUser
      ){
    userService.saveUser(requestUser);
  }
}
