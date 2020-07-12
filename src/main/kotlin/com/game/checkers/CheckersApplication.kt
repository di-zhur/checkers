package com.game.checkers

import com.game.checkers.core.BoardImpl
import com.game.checkers.core.Cell
import com.game.checkers.core.FirstPlayer
import com.game.checkers.core.SecondPlayer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry

@SpringBootApplication
class CheckersApplication

fun main(args: Array<String>) {
	runApplication<CheckersApplication>(*args)
}

@RestController
class CheckersController {

	@GetMapping("/getCheckers")
	fun get(): Set<Cell>  {
		val board = BoardImpl()
		val player1 = FirstPlayer()
		val player2 = SecondPlayer()
		board.initialize(player1, player2)
		return board.getCells()
	}

}

@Configuration
@EnableWebSocket
class WSConfig : WebSocketConfigurer {
	override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
		//registry.addHandler(ChatHandler(), "/chat").withSockJS()
	}
}