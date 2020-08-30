package com.game.checkers.core

import com.game.checkers.db.Board
import com.game.checkers.db.Cell
import com.game.checkers.db.Checker
import com.game.checkers.db.CheckersGame
import com.game.checkers.db.CheckersGameRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

enum class StepType {
    KILL,
    JUMP
}

enum class StepDirection {
    UP,
    DOWN
}

@Service
class GameServiceImpl(private val checkersGameRepository: CheckersGameRepository) : GameService {

    @Transactional
    override fun create() {
        val board = BoardImpl()
        val player1 = FirstPlayer()
        val player2 = SecondPlayer()
        board.initialize(player1, player2)
        val checkersGame = CheckersGame(Board(board.getCells()))
        checkersGameRepository.save(checkersGame)
        TODO()
    }

    override fun start() {
        TODO("Not yet implemented")
    }

    override fun end() {
        TODO("Not yet implemented")
    }

    override fun execute() {
        val board = BoardImpl()
        val player1 = FirstPlayer()
        val player2 = SecondPlayer()
        board.initialize(player1, player2)
        board.getGraphCells()
        print(board.getStepVariants(player1, player2,
                Checker(Cell(3, 3))))

        board.step(player1,
                Checker(Cell(3, 3)),
                Cell(4, 4))
    }

    override fun complete() {
        TODO("Not yet implemented")
    }

}