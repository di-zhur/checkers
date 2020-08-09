package com.game.checkers

import com.game.checkers.core.*
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class CheckersApplication

fun main(args: Array<String>) {
	runApplication<CheckersApplication>(*args)
}

@RestController
class CheckersController(private val checkerRepository: CheckerRepository) {

	@GetMapping("/getCheckers")
	fun getCheckers(): Set<Cell>  {
		val checker = Checker(Cell(3, 3))
		checkerRepository.save(checker)
		val board = BoardImpl()
		val player1 = FirstPlayer()
		val player2 = SecondPlayer()
		board.initialize(player1, player2)
		return board.getCells()
	}

	@GetMapping("/getSteps")
	fun getSteps(@RequestBody stepCell: Cell): Set<Cell>  {
		return mutableSetOf()
	}

	@PostMapping("/step")
	fun step(@RequestBody stepCell: Cell, checkerId: String) {

	}

	@GetMapping("/isActivePlayer")
	fun isActivePlayer(playerId: String): Boolean  {
		return false
	}

}

/*
@Configuration
@EnableWebSocket
class WSConfig : WebSocketConfigurer {
	override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
		//registry.addHandler(ChatHandler(), "/chat").withSockJS()
	}
}*/
