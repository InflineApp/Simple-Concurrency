package com.project.concurrency.app.data.counter_race

import com.project.concurrency.app.domain.models.counter_race.CounterRaceParams
import com.project.concurrency.app.domain.models.counter_race.CounterRaceResult
import com.project.concurrency.app.ui.screens.counter_race_screen.models.CounterRaceMode
import kotlin.concurrent.thread

class CounterRaceRunner {

    fun run(counterRaceParams: CounterRaceParams) : CounterRaceResult{
        val counter = getCounter(counterRaceParams.mode)
        val counterRaceResult = runExperiment(
            counterRaceParams = counterRaceParams,
            counter = counter
        )
        return counterRaceResult
    }

    private fun getCounter(mode: CounterRaceMode) : Counter {
        return when(mode){
            CounterRaceMode.UNSAFE -> UnsafeCounter()
            CounterRaceMode.LOCK -> LockCounter()
            CounterRaceMode.ATOMIC -> AtomicCounter()
            CounterRaceMode.SYNCHRONIZED -> SynchronizedCounter()
        }
    }

    private fun runExperiment(
        counterRaceParams: CounterRaceParams,
        counter: Counter
    ) : CounterRaceResult {
        val start = System.currentTimeMillis()

        val threadsList = mutableListOf<Thread>()

        val workersCount = counterRaceParams.workersCount
        val incrementsPerWorker = counterRaceParams.incrementsPerWorker

        repeat(workersCount){
            val thread = thread {
                repeat(incrementsPerWorker){
                    counter.increment()
                }
            }
            threadsList.add(thread)
        }
        threadsList.forEach { thread ->
            thread.join()
        }

        val i = counter.get()
        val end = System.currentTimeMillis()
        return CounterRaceResult(
            expected = workersCount*incrementsPerWorker,
            actual = i,
            lostUpdates = workersCount*incrementsPerWorker-i,
            executionTime = end - start
        )
    }
}