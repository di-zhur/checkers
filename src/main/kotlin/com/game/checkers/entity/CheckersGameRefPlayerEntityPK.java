package com.game.checkers.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CheckersGameRefPlayerEntityPK implements Serializable {
    private Object checkersGameId;
    private Object playerId;

    @Column(name = "checkers_game_id")
    @Id
    public Object getCheckersGameId() {
        return checkersGameId;
    }

    public void setCheckersGameId(Object checkersGameId) {
        this.checkersGameId = checkersGameId;
    }

    @Column(name = "player_id")
    @Id
    public Object getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Object playerId) {
        this.playerId = playerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckersGameRefPlayerEntityPK that = (CheckersGameRefPlayerEntityPK) o;
        return Objects.equals(checkersGameId, that.checkersGameId) &&
                Objects.equals(playerId, that.playerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkersGameId, playerId);
    }
}
