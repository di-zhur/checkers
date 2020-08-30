package com.game.checkers.db

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.game.checkers.core.Horizontal
import com.game.checkers.core.StateCell
import com.game.checkers.core.Vertical
import com.vladmihalcea.hibernate.type.json.JsonBinaryType
import com.vladmihalcea.hibernate.type.json.JsonStringType
import org.hibernate.annotations.Type
import org.hibernate.annotations.TypeDef
import org.hibernate.annotations.TypeDefs
import java.util.*
import javax.persistence.*

/**
 * Сущность "Шашка"
 */
@TypeDefs(
        TypeDef(name = "json", typeClass = JsonStringType::class),
        TypeDef(name = "jsonb", typeClass = JsonBinaryType::class)
)
@Entity
@Table(name = "checker", schema = "public", catalog = "checkers-game")
data class Checker (
        @Type(type = "jsonb")
        @Column(name = "value", columnDefinition = "json")
        var cell: Cell,

        @Column(name = "id", columnDefinition = "uuid")
        @Id
        var id: UUID = UUID.randomUUID()
)

/**
 * Сущность "Позиции/перемещения шашки"
 */
@TypeDefs(
        TypeDef(name = "json", typeClass = JsonStringType::class),
        TypeDef(name = "jsonb", typeClass = JsonBinaryType::class)
)
@Entity
@Table(name = "checker_steps", schema = "public", catalog = "checkers-game")
data class CheckerSteps (
        @Type(type = "jsonb")
        @Column(name = "value", columnDefinition = "json")
        var cell: Cell,

        @Column(name = "date", columnDefinition = "date")
        var date: Date = Date(),

        @Column(name = "id", columnDefinition = "uuid")
        @Id
        var id: UUID = UUID.randomUUID()
)

/**
 * Сущность "Ячека доски"
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class Cell(val verticalIndex: Int, val horizontalIndex: Int, val stateCell: StateCell = StateCell.ACTIVE) {

    fun getVertical() = Vertical.getValue(verticalIndex)

    fun getHorizontal() = Horizontal.getValue(horizontalIndex)

    override fun toString()= "(${getVertical()}, ${getHorizontal()}, ${stateCell})"
}

/**
 * Сущность "Игра шашки"
 */
@TypeDefs(
        TypeDef(name = "json", typeClass = JsonStringType::class),
        TypeDef(name = "jsonb", typeClass = JsonBinaryType::class)
)
@Entity
@Table(name = "checkers_game", schema = "public", catalog = "checkers-game")
data class CheckersGame (
        @Type(type = "jsonb")
        @Column(name = "value", columnDefinition = "json")
        var board: Board,

        @Column(name = "start_date", columnDefinition = "date")
        var startDate: Date? = null,

        @Column(name = "end_date", columnDefinition = "date")
        var endDate: Date? = null,

        @Column(name = "id", columnDefinition = "uuid")
        @Id
        var id: UUID = UUID.randomUUID()
)

/**
 * Сущность "Доска игры"
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class Board(val cells: Set<Cell>)

/**
 * Сущность "Игрок"
 */
@Entity
@Table(name = "player", schema = "public", catalog = "checkers-game")
data class Player (
        @Column(name = "name")
        @Basic
        val name: String,

        @Column(name = "email")
        @Basic
        val email: String? = null,

        @Column(name = "id", columnDefinition = "uuid")
        @Id
        var id: UUID = UUID.randomUUID()
)