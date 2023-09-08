package com.zerobase.productapi.controller;

import com.zerobase.productapi.dto.RequestProduct;
import com.zerobase.productapi.dto.ResponseCommon;
import com.zerobase.productapi.dto.ResponseProduct;
import com.zerobase.productapi.dto.Type.OrgCode;
import com.zerobase.productapi.service.ProductService;
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
