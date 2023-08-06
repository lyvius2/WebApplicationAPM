package com.walter.api.controller.vo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class GameConsoleV1 {
	private long seq;
	private String console;
	private String manufacturerCompany;
	private String companyAddress;
	private int generation;
	private String releaseDate;
	private LocalDateTime registeredDate;
	private LocalDateTime updatedDate;
}
