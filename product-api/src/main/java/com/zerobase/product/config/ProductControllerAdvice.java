package com.zerobase.product.config;

import com.zerobase.product.error.ProductErrorResponse;
import com.zerobase.product.error.ProductException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import static com.zerobase.product.error.type.ProductErrorCode.TYPE_MISMATCH;

@RestControllerAdvice
public class ProductControllerAdvice {
  @ExceptionHandler({MethodArgumentTypeMismatchException.class})
  public ProductErrorResponse handleAllException(MethodArgumentTypeMismatchException e) {
    return new ProductErrorResponse(TYPE_MISMATCH, e.getName());
  }

  @ExceptionHandler({ProductException.class})
  public ProductErrorResponse hanlderUserException(ProductException e) {
    return new ProductErrorResponse(e.getProductErrorCode(), e.getErrorMessage());
  }
}
