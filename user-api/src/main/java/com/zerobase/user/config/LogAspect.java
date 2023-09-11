package com.zerobase.user.config;

import com.zerobase.domain.type.AopCurrent;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static com.zerobase.domain.type.AopCurrent.AFTER;
import static com.zerobase.domain.type.AopCurrent.BEFORE;

@Component
@Aspect
public class LogAspect {

  private final Logger logger = LoggerFactory.getLogger(LogAspect.class);
  @Pointcut(value = "within(com.zerobase.*.controller.*)")
  public void currentControllerLocation() {}

  @Pointcut(value = "within(com.zerobase.*.service.*)")
  public void currentServiceLocation() {}

  @Before("(currentServiceLocation() || currentControllerLocation())")
  private void beforeLog(JoinPoint joinPoint) {
    getLog(joinPoint , BEFORE);
  }
  @After("currentServiceLocation() || currentControllerLocation()")
  private void afterLog(JoinPoint joinPoint) {
    getLog(joinPoint, AFTER);
  }
  private void getLog(JoinPoint joinPoint, AopCurrent input) {
    String methodName = joinPoint.getSignature().getName();
    String className = joinPoint.getTarget().getClass().getName();
    logger.info(input + " calling method: " + methodName + " in class: " + className);
  }
}
