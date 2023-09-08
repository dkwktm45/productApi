package com.zerobase.productapi.dto.converter;

import com.zerobase.productapi.dto.Type.OrgCode;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;

@Convert
public class OrgConverter implements AttributeConverter<OrgCode,
    String> {
  @Override
  public String convertToDatabaseColumn(OrgCode attribute) {
    if (attribute.getValue() == null) return null;
    return attribute.getValue();
  }

  @Override
  public OrgCode convertToEntityAttribute(String dbData) {
    if (dbData == null) {
      return null;
    }
    try {
      return OrgCode.getCode(dbData);
    } catch (IllegalCallerException e) {
      throw e;
    }
  }
}
