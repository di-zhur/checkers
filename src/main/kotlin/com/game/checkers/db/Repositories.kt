package com.game.checkers.db

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CheckerRepository: JpaRepository<Checker, UUID>

@Repository
interface CheckerStepsRepository: JpaRepository<CheckerSteps, UUID>

@Repository
interface CheckersGameRepository: JpaRepository<CheckersGame, UUID>

