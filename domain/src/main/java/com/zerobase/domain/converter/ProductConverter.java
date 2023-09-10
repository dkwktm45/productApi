package com.zerobase.domain.converter;

import com.zerobase.domain.type.ProductCode;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;

@Convert
public class ProductConverter implements AttributeConverter<ProductCode,
    String> {
  @Override
  public String convertToDatabaseColumn(ProductCode attribute) {
    if (attribute.getValue() == null) return null;
    return attribute.getValue();
  }

  @Override
  public ProductCode convertToEntityAttribute(String dbData) {
    if (dbData == null) {
      return null;
    }
    try {
      return ProductCode.getCode(dbData);
    } catch (IllegalCallerException e) {
      throw e;
    }
  }
}
