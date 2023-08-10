package com.walter.api.controller.vo;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class GameConsoleParam {
	@NotNull
	private String manufacturer;

	@NotNull
	private String console;

	@Min(3)
	private int generation;

	private String releaseDate;
}
