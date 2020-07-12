package com.game.checkers.core

interface Player {
    val stepDirection: StepDirection
}

class FirstPlayer(val name: String = "FirstPlayer", val email: String = "") : Player {
    override val stepDirection: StepDirection = StepDirection.UP
}

class SecondPlayer(val name: String = "SecondPlayer", val email: String = "") : Player {
    override val stepDirection: StepDirection = StepDirection.DOWN
}
