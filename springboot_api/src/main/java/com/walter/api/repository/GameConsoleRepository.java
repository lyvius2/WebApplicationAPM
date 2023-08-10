package com.walter.api.repository;

import com.walter.api.entity.GameConsole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameConsoleRepository extends JpaRepository<GameConsole, Long> {
	GameConsole findBySeq(long seq);
}
