package com.game.checkers.core

import com.game.checkers.db.Cell
import com.game.checkers.db.Checker

enum class Vertical(private val index: Int) {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8);

    fun getIndex() = index

    companion object {
        fun getValue(index: Int) : Vertical = values().first { it.index == index }
    }
}

enum class Horizontal(private val index: Int) {
    A(1),
    B(2),
    C(3),
    D(4),
    E(5),
    F(6),
    G(7),
    H(8);

    fun getIndex() = index

    companion object {
        fun getValue(index: Int) : Horizontal = values().first { it.index == index }
    }
}

enum class StateCell {
    ACTIVE,
    PASSIVE
}


class BoardImpl : Board {
    private val graphCells = mutableMapOf<Cell, Set<Cell>>()
    private val playerCheckers = mutableMapOf<Player, MutableSet<Checker>>()

    override fun initialize(firstPlayer: Player, secondPlayer: Player) {
        val range: IntRange = 1..8
        for (verticalIndex in range) {
            for (horizontalIndex in range) {
                if (verticalIndex.plus(horizontalIndex).rem(2) == 0) {
                    val prevHorizontalIndex = horizontalIndex.minus(1)
                    val nextHorizontalIndex = horizontalIndex.plus(1)
                    val prevVerticalIndex = verticalIndex.minus(1)
                    val nextVerticalIndex = verticalIndex.plus(1)

                    val relatedCells = mutableSetOf<Cell>()
                    if (prevHorizontalIndex in range) {
                        if (prevVerticalIndex in range) {
                            relatedCells.add(Cell(prevVerticalIndex, prevHorizontalIndex))
                        }

                        if (nextVerticalIndex in range) {
                            relatedCells.add(Cell(nextVerticalIndex, prevHorizontalIndex))
                        }
                    }

                    if (nextHorizontalIndex in range) {
                        if (prevVerticalIndex in range) {
                            relatedCells.add(Cell(prevVerticalIndex, nextHorizontalIndex))
                        }

                        if (nextVerticalIndex in range) {
                            relatedCells.add(Cell(nextVerticalIndex, nextHorizontalIndex))
                        }
                    }

                    graphCells[Cell(verticalIndex, horizontalIndex)] = relatedCells
                } else {
                    graphCells[Cell(verticalIndex, horizontalIndex, StateCell.PASSIVE)] = emptySet()
                }
            }
        }

        playerCheckers[firstPlayer] = getCheckersPlayer(1..3)
        playerCheckers[secondPlayer] = getCheckersPlayer(6..8)
    }

    private fun getCheckersPlayer(range: IntRange) : MutableSet<Checker> = graphCells.keys
            .filter { it.verticalIndex in range }
            .map { cell -> Checker(cell) }
            .toMutableSet()

    override fun getChecker(player: Player, checker: Checker) : Checker? =
            playerCheckers[player]
                    ?.first { it == checker }

    override fun getCheckers(player: Player) : MutableSet<Checker> = playerCheckers[player]!!

    override fun getGraphCells() : Map<Cell, Set<Cell>> = graphCells

    override fun getCells() : Set<Cell> = graphCells.keys.toSet()

    override fun getPlayerCheckers() : Map<Player, MutableSet<Checker>> = playerCheckers

    override fun getStepVariants(activePlayer: Player, passivePlayer: Player, checker: Checker) : List<Pair<StepType, Cell>> {
        val checkerCell = checker.cell
        val passiveCheckerCells = playerCheckers[passivePlayer]!!.map { it.cell }
        val relatedCells = graphCells[checkerCell]!!
        val variantCells = mutableListOf<Pair<StepType, Cell>>()

        //1. Cells for next step
        val nextStepVerticalIndex = when (activePlayer.stepDirection) {
            StepDirection.UP -> {
                relatedCells.maxBy { it.verticalIndex }!!
                        .getVertical()
                        .getIndex()
            }
            StepDirection.DOWN -> {
                relatedCells.minBy { it.verticalIndex }!!
                        .getVertical()
                        .getIndex()
            }
        }
        relatedCells.filter { it.verticalIndex == nextStepVerticalIndex }.forEach{
            if (!passiveCheckerCells.contains(it)) {
                variantCells.add(Pair(StepType.JUMP, it))
            }
        }

        //2. Cells for eat next step
        relatedCells.forEach{
            if (passiveCheckerCells.contains(it)) {
                val nextVerticalIndex = if (checkerCell.verticalIndex > it.verticalIndex) {
                    it.verticalIndex.minus(1)
                } else {
                    it.verticalIndex.plus(1)
                }

                val nextHorizontalIndex = if (checkerCell.horizontalIndex > it.horizontalIndex) {
                    it.horizontalIndex.minus(1)
                } else {
                    it.horizontalIndex.plus(1)
                }

                val nextCell = Cell(nextVerticalIndex, nextHorizontalIndex, StateCell.ACTIVE)
                if (!passiveCheckerCells.contains(nextCell)) {
                    variantCells.add(Pair(StepType.KILL, nextCell))
                }
            }
        }

        return variantCells
    }

    fun step(player: Player, checker: Checker, newCell: Cell) {
        getCheckers(player).removeIf { it.id == checker.id }
        checker.cell = newCell
        getCheckers(player).add(checker)
    }

}
