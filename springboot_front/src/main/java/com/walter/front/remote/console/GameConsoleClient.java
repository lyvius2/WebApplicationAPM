package com.walter.front.remote.console;

import com.walter.front.remote.console.dto.GameConsole;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "console", fallbackFactory = GameConsoleClientFallbackFactory.class)
public interface GameConsoleClient {
	@GetMapping("/console")
	List<GameConsole> getConsoles();
}
