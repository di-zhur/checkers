package com.game.checkers.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "checkers_game_ref_player", schema = "public", catalog = "checkers-game")
@IdClass(CheckersGameRefPlayerEntityPK.class)
public class CheckersGameRefPlayerEntity {
    private Object checkersGameId;
    private Object playerId;
    private Object value;
    private CheckersGameEntity checkersGameByCheckersGameId;
    private CheckerColorEntity checkerColorByCheckerColorId;

    @Id
    @Column(name = "checkers_game_id")
    public Object getCheckersGameId() {
        return checkersGameId;
    }

    public void setCheckersGameId(Object checkersGameId) {
        this.checkersGameId = checkersGameId;
    }

    @Id
    @Column(name = "player_id")
    public Object getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Object playerId) {
        this.playerId = playerId;
    }

    @Basic
    @Column(name = "value")
    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckersGameRefPlayerEntity that = (CheckersGameRefPlayerEntity) o;
        return Objects.equals(checkersGameId, that.checkersGameId) &&
                Objects.equals(playerId, that.playerId) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkersGameId, playerId, value);
    }

    @ManyToOne
    @JoinColumn(name = "checkers_game_id", referencedColumnName = "id", nullable = false)
    public CheckersGameEntity getCheckersGameByCheckersGameId() {
        return checkersGameByCheckersGameId;
    }

    public void setCheckersGameByCheckersGameId(CheckersGameEntity checkersGameByCheckersGameId) {
        this.checkersGameByCheckersGameId = checkersGameByCheckersGameId;
    }

    @ManyToOne
    @JoinColumn(name = "checker_color_id", referencedColumnName = "id")
    public CheckerColorEntity getCheckerColorByCheckerColorId() {
        return checkerColorByCheckerColorId;
    }

    public void setCheckerColorByCheckerColorId(CheckerColorEntity checkerColorByCheckerColorId) {
        this.checkerColorByCheckerColorId = checkerColorByCheckerColorId;
    }
}
