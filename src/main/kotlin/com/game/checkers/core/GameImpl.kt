package com.game.checkers.core

enum class StepType {
    KILL,
    JUMP
}

enum class StepDirection {
    UP,
    DOWN
}

data class Player(val name: String, val stepDirection: StepDirection, val email: String = "")

class GameImpl : Game {

    override fun execute() {
        val board = BoardImpl()
        val player1 = Player("dima", StepDirection.UP)
        val player2 = Player("tom", StepDirection.DOWN)
        board.initialize(player1, player2)
        board.getGraphCells()
        print(board.getStepVariants(Player("dima", StepDirection.UP),
                Player("tom", StepDirection.DOWN),
                Checker(1, Cell(3, 3))))
    }

    override fun complete() {
        TODO("Not yet implemented")
    }

}

fun main(args: Array<String>) {
    val game = GameImpl()
    game.execute()
}