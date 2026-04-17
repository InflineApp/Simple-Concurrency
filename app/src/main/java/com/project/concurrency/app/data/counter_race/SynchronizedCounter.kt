package com.project.concurrency.app.data.counter_race

class SynchronizedCounter : Counter{

    private var value = 0
    private val lock = Any()

    override fun increment() {
        synchronized(lock){
            value++
        }
    }

    override fun get(): Int {
        synchronized(lock) {
            return value
        }
    }

}
