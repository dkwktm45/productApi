package com.zerobase.user.config;

import com.zerobase.user.error.UserErrorResponse;
import com.zerobase.user.error.UserException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import static com.zerobase.user.error.type.UserErrorCode.TYPE_MISMATCH;

@RestControllerAdvice
public class UserControllerAdvice {
  @ExceptionHandler({MethodArgumentTypeMismatchException.class})
  public UserErrorResponse handleAllException(MethodArgumentTypeMismatchException e) {
    return new UserErrorResponse(TYPE_MISMATCH, e.getName());
  }

  @ExceptionHandler({UserException.class})
  public UserErrorResponse hanlderUserException(UserException e) {
    return new UserErrorResponse(e.getUserErrorCode(), e.getErrorMessage());
  }
}
