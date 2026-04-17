package com.project.concurrency.app.domain.models.counter_race

data class CounterRaceResult(
    val expected: Int,
    val actual: Int,
    val lostUpdates: Int,
    val executionTime: Long,
)