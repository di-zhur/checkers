package com.game.checkers.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.vladmihalcea.hibernate.type.json.JsonBinaryType
import com.vladmihalcea.hibernate.type.json.JsonStringType
import org.hibernate.annotations.Type
import org.hibernate.annotations.TypeDef
import org.hibernate.annotations.TypeDefs
import java.util.*
import javax.persistence.*

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

@JsonIgnoreProperties(ignoreUnknown = true)
data class Cell(val verticalIndex: Int, val horizontalIndex: Int, val stateCell: StateCell = StateCell.ACTIVE) {

    fun getVertical() = Vertical.getValue(verticalIndex)

    fun getHorizontal() = Horizontal.getValue(horizontalIndex)

    override fun toString()= "(${getVertical()}, ${getHorizontal()}, ${stateCell})"
}

@Entity
@Table(name = "checker_color", schema = "public", catalog = "checkers-game")
data class CheckerColor (

        @Column(name = "value")
        @Basic
        val value: String? = null,

        @Column(name = "id", columnDefinition = "uuid")
        @Id
        var id: UUID = UUID.randomUUID()
)