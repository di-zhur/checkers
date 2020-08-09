package com.game.checkers.core

enum class StepType {
    KILL,
    JUMP
}

enum class StepDirection {
    UP,
    DOWN
}

class GameImpl : Game {

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

fun main(args: Array<String>) {
    val game = GameImpl()
    game.execute()
}