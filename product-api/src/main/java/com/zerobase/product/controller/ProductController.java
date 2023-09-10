package com.zerobase.product.controller;


import com.zerobase.domain.type.OrgCode;
import com.zerobase.product.dto.RequestProduct;
import com.zerobase.product.dto.ResponseCommon;
import com.zerobase.product.dto.ResponseProduct;
import com.zerobase.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController @RequiredArgsConstructor
@RequestMapping("/fintech/v1/product")
public class ProductController {
  private final ProductService productService;
  @GetMapping("{organizationCode}")
  public ResponseEntity<List<ResponseProduct>> getProductList(
      @PathVariable OrgCode organizationCode
  ){
    return ResponseEntity.ok(productService.getList(organizationCode));
  }

  @PostMapping("/information")
  public ResponseEntity<ResponseCommon> setProduct(
      @RequestBody RequestProduct requestProduct
  ) {
    return ResponseEntity.ok(productService.saveProduct(requestProduct));
  }
}
