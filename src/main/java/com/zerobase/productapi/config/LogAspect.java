package com.zerobase.productapi.config;

import com.zerobase.productapi.dto.Type.AopCurrent;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

  private final Logger logger = LoggerFactory.getLogger(LogAspect.class);
  @Pointcut(value = "within(com.zerobase.productapi.controller.*)")
  public void currentControllerLocation() {}

  @Pointcut(value = "within(com.zerobase.productapi.service.*)")
  public void currentServiceLocation() {}


  @Before("(currentServiceLocation() || currentControllerLocation())")
  private void beforeLog(JoinPoint joinPoint) {
    getLog(joinPoint , AopCurrent.BEFORE);
  }
  @After("currentServiceLocation() || currentControllerLocation()")
  private void afterLog(JoinPoint joinPoint) {
    getLog(joinPoint, AopCurrent.AFTER);
  }
  private void getLog(JoinPoint joinPoint, AopCurrent input) {
    String methodName = joinPoint.getSignature().getName();
    String className = joinPoint.getTarget().getClass().getName();
    logger.info(input + " calling method: " + methodName + " in class: " + className);
  }


}
