package com.zerobase.productapi.config.encrypt;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.lang.reflect.Field;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Component
@Aspect @RequiredArgsConstructor
public class EncryptionAspect {
  private final EncryptionService encryptionService;

  @Pointcut("execution(* com.zerobase.productapi.service.*.find*(..))")
  public void findMethods() {}

  @Pointcut("execution(* com.zerobase.productapi.service.*.save*(..))")
  public void saveMethods() {}

  @Before("findMethods()")
  public void beforeFind(JoinPoint joinPoint) {
    // todo find 함수 호출 전에 복호화 로직 구현
    // 예: 복호화할 필드를 찾아서 암호화 서비스를 사용하여 복호화
  }

  @AfterReturning(pointcut = "findMethods()", returning = "result")
  public void afterFind(JoinPoint joinPoint, Object result) {
    // todo find 함수 호출 후에 추가 작업 (예: 결과를 가공)
  }

  @Before("saveMethods()")
  public void beforeSave(JoinPoint joinPoint) throws IllegalAccessException {
    // save 함수 호출 전에 암호화 로직 구현
    // 예: 암호화할 필드를 찾아서 암호화 서비스를 사용하여 암호화
    Object[] args = joinPoint.getArgs();
    for (Object arg : args) {
      if (arg != null) {
        Field[] fields = arg.getClass().getDeclaredFields();
        for (Field field : fields) {
          if (field.isAnnotationPresent(Encrypt.class)) {
            // @Encrypt 어노테이션이 붙은 필드를 찾았습니다.
            // 이제 암호화 로직을 구현할 수 있습니다.
            try {
              String fieldName = encryptionService.encode((String) field.get(field.getName()));
            } catch (InvalidCipherTextException e) {
              throw new RuntimeException(e);
            } catch (InvalidKeyException e) {
              throw new RuntimeException(e);
            } catch (NoSuchPaddingException e) {
              throw new RuntimeException(e);
            } catch (NoSuchAlgorithmException e) {
              throw new RuntimeException(e);
            } catch (IllegalBlockSizeException e) {
              throw new RuntimeException(e);
            } catch (BadPaddingException e) {
              throw new RuntimeException(e);
            }
            // 필요한 암호화 로직을 구현하십시오.
          }
        }
      }
    }
  }
}