package com.project.concurrency.app.ui.screens.counter_race_screen.models

import com.project.concurrency.app.R

enum class CounterRaceStatus(val title: Int) {
    Idle(R.string.idle),
    Running(R.string.running),
    Completed(R.string.completed),
    Error(R.string.error),
}