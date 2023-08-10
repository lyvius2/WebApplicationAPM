package com.walter.api.controller;

import com.walter.api.config.mapper.GameConsoleMapper;
import com.walter.api.controller.vo.GameConsoleParam;
import com.walter.api.controller.vo.GameConsoleV1;
import com.walter.api.entity.GameConsole;
import com.walter.api.service.GameConsoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Tag(name = "게임 콘솔")
@RequestMapping("/console")
@RestController
public class GameConsoleController {
	private final GameConsoleService gameConsoleService;

	public GameConsoleController(GameConsoleService gameConsoleService) {
		this.gameConsoleService = gameConsoleService;
	}

	@Operation(summary = "게임 콘솔 단일 조회", description = "Sequence 로 게임 콘솔 정보 조회 API")
	@GetMapping("/{seq}")
	public GameConsoleV1 getGameConsole(@PathVariable("seq") long seq) {
		return GameConsoleMapper.INSTANCE.from(gameConsoleService.getConsole(seq));
	}

	@Operation(summary = "게임 콘솔 목록 조회", description = "전체 게임 콘솔 목록 조회 API")
	@GetMapping("/")
	public List<GameConsoleV1> getGameConsoles() {
		final List<GameConsole> gameConsoles = gameConsoleService.getConsoles();
		return gameConsoles.stream().map(GameConsoleMapper.INSTANCE::from)
									.collect(toList());
	}

	@Operation(summary = "게임 콘솔 등록", description = "게임 콘솔 정보 등록 API")
	@PostMapping("/")
	public void createGameConsole(@RequestBody @Validated GameConsoleParam param) {
		gameConsoleService.createConsole(param);
	}

	@Operation(summary = "게임 콘솔 변경", description = "게임 콘솔 정보 변경 API")
	@PutMapping("/{seq}")
	public void updateGameConsole(@PathVariable("seq") long seq,
	                              @RequestBody @Validated GameConsoleParam param) {
		gameConsoleService.updateConsole(seq, param);
	}

	@Operation(summary = "게임 콘솔 삭제", description = "게임 콘솔 정보 삭제 API")
	@DeleteMapping("/{seq}")
	public void deleteGameConsole(@PathVariable("seq") long seq) {
		gameConsoleService.deleteConsole(seq);
	}
}
