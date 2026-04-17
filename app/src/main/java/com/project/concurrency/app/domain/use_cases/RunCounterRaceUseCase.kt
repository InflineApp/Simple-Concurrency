package com.project.concurrency.app.domain.use_cases

import com.project.concurrency.app.data.counter_race.CounterRaceRunner
import com.project.concurrency.app.domain.models.counter_race.CounterRaceParams
import com.project.concurrency.app.domain.models.counter_race.CounterRaceResult

class RunCounterRaceUseCase(
    private val counterRaceRunner: CounterRaceRunner
) {
    operator fun invoke(params: CounterRaceParams) : CounterRaceResult {
        return counterRaceRunner.run(params)
    }
}