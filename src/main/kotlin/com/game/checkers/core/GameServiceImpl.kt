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

    override fun create() {
        TODO("Not yet implemented")
    }

    override fun start() {
        TODO("Not yet implemented")
    }

    override fun end() {
        TODO("Not yet implemented")
    }

    override fun execute() {
        TODO("Not yet implemented")
    }

    override fun complete() {
        TODO("Not yet implemented")
    }

}
