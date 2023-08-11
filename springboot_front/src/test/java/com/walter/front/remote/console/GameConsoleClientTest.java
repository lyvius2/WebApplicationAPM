package com.walter.front.remote.console;

import com.walter.front.remote.console.dto.GameConsole;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class GameConsoleClientTest {
	@Autowired
	GameConsoleClient gameConsoleClient;

	@Test
	@DisplayName("GameConsole API Call 테스트")
	void getConsoles() {
		final List<GameConsole> gameConsoles = gameConsoleClient.getConsoles();
		assertNotNull(gameConsoles);
	}
}