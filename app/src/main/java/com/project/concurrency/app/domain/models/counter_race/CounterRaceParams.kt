package com.project.concurrency.app.domain.models.counter_race

import com.project.concurrency.app.ui.screens.counter_race_screen.models.CounterRaceMode

data class CounterRaceParams(
    val workersCount: Int,
    val incrementsPerWorker: Int,
    val mode: CounterRaceMode
)