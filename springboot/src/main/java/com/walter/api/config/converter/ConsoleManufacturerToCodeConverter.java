package com.walter.api.config.converter;

import com.walter.api.code.Manufacturer;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ConsoleManufacturerToCodeConverter implements AttributeConverter<Manufacturer, String> {
	@Override
	public String convertToDatabaseColumn(Manufacturer attribute) {
		return attribute.name();
	}

	@Override
	public Manufacturer convertToEntityAttribute(String dbData) {
		return Manufacturer.findByCode(StringUtils.upperCase(dbData));
	}
}
