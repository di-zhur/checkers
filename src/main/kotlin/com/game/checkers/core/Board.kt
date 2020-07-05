package com.game.checkers.core

interface Board {

    fun initialize(firstPlayer: Player, secondPlayer: Player)

    fun getChecker(player: Player, checker: Checker) : Checker?

    fun getCheckers(player: Player) : List<Checker>?

    fun getGraphCells() : Map<Cell, List<Cell>>

}