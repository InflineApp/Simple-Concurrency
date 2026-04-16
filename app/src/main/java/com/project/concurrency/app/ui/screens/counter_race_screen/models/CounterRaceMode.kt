package com.project.concurrency.app.ui.screens.counter_race_screen.models

import com.project.concurrency.app.R

enum class CounterRaceMode(val title: Int) {
    UNSAFE(R.string.unsafe),
    SYNCHRONIZED(R.string.synchronized_enum),
    LOCK(R.string.lock),
    ATOMIC(R.string.atomic)
}

