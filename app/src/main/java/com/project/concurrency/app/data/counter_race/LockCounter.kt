package com.project.concurrency.app.data.counter_race

import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

class LockCounter : Counter{

    private var value = 0
    private val lock = ReentrantLock()

    override fun increment() {
        lock.withLock {
            value++
        }
    }

    override fun get(): Int {
        lock.withLock {
            return value
        }
    }

}