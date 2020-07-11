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
        val player1 = PlayerFirst("Dima")
        val player2 = PlayerSecond("Tom")
        board.initialize(player1, player2)
        board.getGraphCells()
        print(board.getStepVariants(player1, player2,
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