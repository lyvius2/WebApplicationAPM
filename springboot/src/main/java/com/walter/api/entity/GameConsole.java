package com.walter.api.entity;

import com.walter.api.code.Manufacturer;
import com.walter.api.config.converter.ConsoleManufacturerToCodeConverter;
import com.walter.api.controller.vo.GameConsoleParam;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "GAME_CONSOLE")
public class GameConsole {
	@Id
	@Column(name = "SEQ")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long seq;

	@Convert(converter = ConsoleManufacturerToCodeConverter.class)
	@Column(name = "MANUFACTURER")
	private Manufacturer manufacturer;

	@Column(name = "CONSOLE")
	private String console;

	@Column(name = "GENERATION")
	private int generation;

	@Column(name = "RELEASE_DATE")
	private String releaseDate;

	@Column(name = "REGISTERED_DATE")
	private LocalDateTime registeredDate = LocalDateTime.now();

	@Column(name = "UPDATED_DATE")
	private LocalDateTime updatedDate;

	public void setUpdate(GameConsoleParam param) {
		if (param == null) {
			return;
		}
		this.manufacturer = Manufacturer.findByCode(param.getManufacturer());
		this.console = param.getConsole();
		this.generation = param.getGeneration();
		this.releaseDate = param.getReleaseDate();
		this.updatedDate = LocalDateTime.now();
	}

	public static GameConsole of(GameConsoleParam param) {
		final GameConsole gameConsole = new GameConsole();
		gameConsole.manufacturer = Manufacturer.findByCode(param.getManufacturer());
		gameConsole.console = param.getConsole();
		gameConsole.generation = param.getGeneration();
		gameConsole.releaseDate = param.getReleaseDate();
		return gameConsole;
	}
}
