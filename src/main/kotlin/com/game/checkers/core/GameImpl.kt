package com.game.checkers.core

enum class DirectionStep {
    UP,
    DOWN
}

data class Player(val name: String, val directionStep: DirectionStep, val email: String = "")

class GameImpl : Game {

    override fun execute() {
        val board = BoardImpl()
        val player1 = Player("dima", DirectionStep.UP)
        val player2 = Player("tom", DirectionStep.DOWN)
        board.initialize(player1, player2)
        board.getGraphCells()
        //print(board.getStepVariants(Player("dima", DirectionStep.UP), Cell(1, 1)))
    }

    override fun complete() {
        TODO("Not yet implemented")
    }

}

fun main(args: Array<String>) {
    val game = GameImpl()
    game.execute()
}