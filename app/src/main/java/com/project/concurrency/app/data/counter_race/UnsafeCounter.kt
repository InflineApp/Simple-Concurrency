package com.project.concurrency.app.data.counter_race

class UnsafeCounter : Counter{

    private var value = 0

    override fun increment() {
        value++
    }

    override fun get(): Int {
        return value
    }

}