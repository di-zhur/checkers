package com.game.checkers.core

interface Player {
    val stepDirection: StepDirection
}

class PlayerFirst(val name: String, val email: String = "") : Player {
    override val stepDirection: StepDirection
        get() = StepDirection.UP
}

class PlayerSecond(val name: String, val email: String = "") : Player {
    override val stepDirection: StepDirection
        get() = StepDirection.DOWN
}