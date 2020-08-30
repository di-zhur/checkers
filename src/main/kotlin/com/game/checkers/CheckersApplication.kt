package com.game.checkers

import com.game.checkers.core.BoardImpl
import com.game.checkers.core.FirstPlayer
import com.game.checkers.core.GameService
import com.game.checkers.core.SecondPlayer
import com.game.checkers.db.Cell
import com.game.checkers.db.Checker
import com.game.checkers.db.CheckerRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@SpringBootApplication
@EnableWebMvc
class CheckersApplication

fun main(args: Array<String>) {
	runApplication<CheckersApplication>(*args)
}

@Controller
class IndexController {

	@GetMapping("/")
	fun index(): String {
		return "index"
	}

}

@RestController
class GameController(private val gameService: GameService){

	@PostMapping("/create")
	fun create() {
		gameService.create()
	}

	@PostMapping("/start")
	fun start() {
		TODO()
		val player1 = FirstPlayer()
		val player2 = SecondPlayer()

	}

	@PostMapping("/end")
	fun end() {

	}

}

@RestController
class BoardController(private val checkerRepository: CheckerRepository) {

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
