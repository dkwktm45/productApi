package com.zerobase.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

  @GetMapping("tset")
  @ResponseBody
  public String test() {
    return "tset";
  }
}
