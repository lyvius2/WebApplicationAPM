package com.walter.front.remote.console.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class GameConsole {
	private long seq;
	private String console;
	private String manufacturerCompany;
	private String companyAddress;
	private int generation;
	private String releaseDate;
	private LocalDateTime registeredDate;
	private LocalDateTime updatedDate;
}
