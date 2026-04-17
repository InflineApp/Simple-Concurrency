package com.project.concurrency.app.data.counter_race

interface Counter{
    fun increment()
    fun get() : Int
}