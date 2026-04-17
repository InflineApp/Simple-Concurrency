package com.project.concurrency.app.data.counter_race

import java.util.concurrent.atomic.AtomicInteger

class AtomicCounter : Counter {

    private val value = AtomicInteger()

    override fun increment() {
        value.incrementAndGet()
    }

    override fun get(): Int {
        return value.get()
    }

}