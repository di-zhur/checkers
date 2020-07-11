package com.game.checkers.core

interface Board {

    fun initialize(firstPlayer: Player, secondPlayer: Player)

    fun getChecker(player: Player, checker: Checker) : Checker?

    fun getCheckers(player: Player) : Set<Checker>?

    fun getGraphCells() : Map<Cell, Set<Cell>>

    fun getStepVariants(activePlayer: Player, passivePlayer: Player, checker: Checker) : List<Pair<StepType, Cell>>
}