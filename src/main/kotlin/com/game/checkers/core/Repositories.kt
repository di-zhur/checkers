package com.game.checkers.core

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CheckerColorRepository: JpaRepository<CheckerColor, UUID>

@Repository
interface CheckerRepository: JpaRepository<Checker, UUID>