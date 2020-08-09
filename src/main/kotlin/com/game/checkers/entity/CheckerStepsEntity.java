package com.game.checkers.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "checker_steps", schema = "public", catalog = "checkers-game")
public class CheckerStepsEntity {
    private Object id;
    private Date date;
    private Object value;
    private CheckerEntity checkerByCheckerId;

    @Id
    @Column(name = "id")
    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        CheckerStepsEntity that = (CheckerStepsEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(date, that.date) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, value);
    }

    @ManyToOne
    @JoinColumn(name = "checker_id", referencedColumnName = "id")
    public CheckerEntity getCheckerByCheckerId() {
        return checkerByCheckerId;
    }

    public void setCheckerByCheckerId(CheckerEntity checkerByCheckerId) {
        this.checkerByCheckerId = checkerByCheckerId;
    }
}
