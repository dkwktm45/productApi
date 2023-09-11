package com.zerobase.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableCaching
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.zerobase.*.*"})
@EnableJpaRepositories(basePackages = {"com.zerobase.domain.repository"})
@EntityScan(basePackages = {"com.zerobase.domain.entity"})
public class ProductApplication {
  public static void main(String[] args) {
    SpringApplication.run(ProductApplication.class, args);
  }
}
