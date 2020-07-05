package com.game.checkers.core

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
        fun getValue(index: Int) : Vertical = values().first { it -> it.index == index }
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
        fun getValue(index: Int) : Horizontal = values().first { it -> it.index == index }
    }
}

data class Checker(val id: Int, val cell: Cell)

data class Cell(val verticalIndex: Int, val horizontalIndex: Int) {

    fun getVertical() = Vertical.getValue(verticalIndex)

    fun getHorizontal() = Horizontal.getValue(horizontalIndex)

    override fun toString()= "(${getVertical()}, ${getHorizontal()})"
}

class BoardImpl : Board {
    private val graphCells = mutableMapOf<Cell, List<Cell>>()
    private val playerCheckers = mutableMapOf<Player, List<Checker>>()

    override fun initialize(firstPlayer: Player, secondPlayer: Player) {
        val range: IntRange = 1..8
        for (verticalIndex in range) {
            for (horizontalIndex in range) {
                if (verticalIndex.plus(horizontalIndex).rem(2) == 0) {
                    val prevHorizontalIndex = horizontalIndex.minus(1)
                    val nextHorizontalIndex = horizontalIndex.plus(1)
                    val prevVerticalIndex = verticalIndex.minus(1)
                    val nextVerticalIndex = verticalIndex.plus(1)

                    val relatedCells = mutableListOf<Cell>()
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
                }
            }
        }

        playerCheckers[firstPlayer] = getCheckersPlayer(1..3)
        playerCheckers[secondPlayer] = getCheckersPlayer(6..8)
    }

    override fun getChecker(player: Player, checker: Checker) : Checker? =
            playerCheckers[player]
                    ?.first { it == checker }

    override fun getCheckers(player: Player) : List<Checker>? = playerCheckers[player]

    override fun getGraphCells() : Map<Cell, List<Cell>> = graphCells

    private fun getCheckersPlayer(range: IntRange) = graphCells.keys
            .filter { it.verticalIndex in range }
            .mapIndexed { index, cell -> Checker(index + 1, cell) }
}
