package com.zerobase.productapi.config.encrypt;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Documented
@Component
@Retention(RetentionPolicy.RUNTIME)
public @interface Encrypt {
}
