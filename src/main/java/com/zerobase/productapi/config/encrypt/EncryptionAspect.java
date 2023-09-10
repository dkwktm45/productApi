package com.zerobase.productapi.config.encrypt;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

import static com.zerobase.productapi.dto.Type.Crypt.DEENCRYPT;
import static com.zerobase.productapi.dto.Type.Crypt.ENCRYPT;

@Component
@Aspect
@RequiredArgsConstructor
public class EncryptionAspect {
  private final EncryptionService encryptionService;

  @Pointcut("execution(* com.zerobase.productapi.service.*.find*(..))")
  public void findMethods() {
  }

  @Pointcut("execution(* com.zerobase.productapi.service.*.save*(..))")
  public void saveMethods() {
  }

  @AfterReturning(pointcut = "findMethods()", returning = "result")
  public void afterFind(JoinPoint joinPoint, Object result) throws IllegalAccessException {
    searchArg(result, DEENCRYPT.name());
  }

  @Before("saveMethods()")
  public void beforeSave(JoinPoint joinPoint) throws IllegalAccessException {
    // save 함수 호출 전에 암호화 로직 구현
    // 예: 암호화할 필드를 찾아서 암호화 서비스를 사용하여 암호화
    Object[] args = joinPoint.getArgs();
    for (Object arg : args) {
      if (arg != null) {
        searchArg(arg, ENCRYPT.name());
      }
    }
  }

  private void searchArg(Object arg, String mode) throws IllegalAccessException {
    Field[] fields = arg.getClass().getDeclaredFields();
    for (Field field : fields) {

      if (field.isAnnotationPresent(Encrypt.class)) {
        field.setAccessible(true);
        if (field.getType() == String.class) {
          String value = (String) field.get(arg);
          String cryptedValue;
          if (mode.equals("ENCRYPT")) {
            cryptedValue =
                encryptionService.encode(value);
          }else{
            cryptedValue =
                encryptionService.decode(value);
          }
          if (cryptedValue != null) {
            field.set(arg, cryptedValue);
          }
        }
      }
    }
  }
}