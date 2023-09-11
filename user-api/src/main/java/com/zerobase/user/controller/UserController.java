package com.zerobase.user.controller;


import com.zerobase.user.dto.RequestUser;
import com.zerobase.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fintech/v1/user")
public class UserController {
  private final UserService userService;

  @PostMapping("/information")
  @Operation(summary = "유저에 대한 정보를 저장")
  public ResponseEntity<?> reqUserSave(
      @RequestBody RequestUser requestUser
      ){
    return ResponseEntity.ok(userService.saveUser(requestUser));
  }
  @GetMapping("/private-info/{userKey}")
  @Operation(summary = "유저에 대한 정보를 반환")
  public ResponseEntity<?> reqUserInfo(
      @PathVariable String userKey
  ){
    return ResponseEntity.ok(userService.findUser(userKey));
  }
}
