package com.walter.front.controller;

import com.walter.front.remote.console.GameConsoleClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FrontController {
	private final GameConsoleClient gameConsoleClient;

	public FrontController(GameConsoleClient gameConsoleClient) {
		this.gameConsoleClient = gameConsoleClient;
	}

	@GetMapping("/console/list")
	public ModelAndView getConsoles() {
		ModelAndView mav = new ModelAndView("consoles");
		mav.addObject("list", gameConsoleClient.getConsoles());
		return mav;
	}
}
