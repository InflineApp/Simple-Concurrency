package com.project.concurrency.app.ui.screens.counter_race_screen.models

data class CounterRaceUiState(
    val workersCount: String = "",
    val incrementsPerWorker: String = "",
    val selectedMode: CounterRaceMode = CounterRaceMode.UNSAFE,
    val expected: Int = 0,
    val actual: Int = 0,
    val lostUpdates: Int = 0,
    val executionTime: Long? = null,
    val status: CounterRaceStatus = CounterRaceStatus.Idle,
    val logs : List<String> = emptyList()
)