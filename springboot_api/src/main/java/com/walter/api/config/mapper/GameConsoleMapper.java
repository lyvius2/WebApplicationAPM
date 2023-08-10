package com.walter.api.config.mapper;

import com.walter.api.controller.vo.GameConsoleV1;
import com.walter.api.entity.GameConsole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GameConsoleMapper {
	GameConsoleMapper INSTANCE = Mappers.getMapper(GameConsoleMapper.class);

	@Mappings({
			@Mapping(source = "manufacturer.company", target = "manufacturerCompany"),
			@Mapping(source = "manufacturer.address", target = "companyAddress")
	})
	GameConsoleV1 from(GameConsole gameConsole);
}
