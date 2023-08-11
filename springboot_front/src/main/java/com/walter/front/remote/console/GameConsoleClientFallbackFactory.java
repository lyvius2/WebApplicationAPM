package com.walter.front.remote.console;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class GameConsoleClientFallbackFactory implements FallbackFactory<GameConsoleClient> {
	@Override
	public GameConsoleClient create(Throwable cause) {
		return () -> {
			log.error("Call GameConsole API Error : {}", cause.getMessage());
			return List.of();
		};
	}
}
