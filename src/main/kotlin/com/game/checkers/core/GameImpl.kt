package com.game.checkers.core

data class Player(val name: String, val email: String = "")

class GameImpl : Game {

    override fun execute() {
        val board = BoardImpl()
        board.initialize(Player("dima"), Player("tom"))
        board.getGraphCells()
    }

    override fun complete() {
        TODO("Not yet implemented")
    }

}

fun main(args: Array<String>) {
    val game = GameImpl()
    game.execute()
}