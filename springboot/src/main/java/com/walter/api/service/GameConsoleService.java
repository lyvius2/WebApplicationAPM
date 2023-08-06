package com.walter.api.service;

import com.walter.api.controller.vo.GameConsoleParam;
import com.walter.api.entity.GameConsole;
import com.walter.api.repository.GameConsoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameConsoleService {
	private final GameConsoleRepository gameConsoleRepository;

	public GameConsoleService(GameConsoleRepository gameConsoleRepository) {
		this.gameConsoleRepository = gameConsoleRepository;
	}

	public List<GameConsole> getConsoles() {
		return gameConsoleRepository.findAll();
	}

	public GameConsole getConsole(long seq) {
		return gameConsoleRepository.findBySeq(seq);
	}

	public void createConsole(GameConsoleParam param) {
		final GameConsole gameConsole = GameConsole.of(param);
		gameConsoleRepository.save(gameConsole);
	}

	public void updateConsole(long seq, GameConsoleParam param) {
		final GameConsole targetConsole = getConsole(seq);
		if (targetConsole == null) {
			return;
		}
		targetConsole.setUpdate(param);
		gameConsoleRepository.save(targetConsole);
	}

	public void deleteConsole(long seq) {
		final GameConsole targetConsole = getConsole(seq);
		if (targetConsole != null) {
			gameConsoleRepository.delete(targetConsole);
		}
	}
}
