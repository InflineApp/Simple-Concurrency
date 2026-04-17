package com.project.concurrency.app.ui.screens.counter_race_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.concurrency.app.data.counter_race.CounterRaceRunner
import com.project.concurrency.app.domain.models.counter_race.CounterRaceParams
import com.project.concurrency.app.domain.use_cases.RunCounterRaceUseCase
import com.project.concurrency.app.ui.screens.counter_race_screen.models.CounterRaceMode
import com.project.concurrency.app.ui.screens.counter_race_screen.models.CounterRaceStatus
import com.project.concurrency.app.ui.screens.counter_race_screen.models.CounterRaceUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.cancellation.CancellationException

class CounterRaceViewModel(
    private val runCounterRaceUseCase: RunCounterRaceUseCase = RunCounterRaceUseCase(
        counterRaceRunner = CounterRaceRunner()
    )
) : ViewModel() {

    private val _uiState = MutableStateFlow(CounterRaceUiState())
    val uiState = _uiState.asStateFlow()

    fun onWorkersCountChanged(value: String){
        _uiState.update {
            it.copy(workersCount = value)
        }
    }

    fun onIncrementsPerWorkerChanged(value: String){
        _uiState.update {
            it.copy(incrementsPerWorker = value)
        }
    }

    fun onModeSelected(mode: CounterRaceMode){
        _uiState.update {
            it.copy(selectedMode = mode)
        }
    }

    fun onResetClicked(){
        _uiState.value = CounterRaceUiState()
    }

    fun onRunClicked(){
        if (_uiState.value.status == CounterRaceStatus.Running) return
        if(_uiState.value.workersCount.isEmpty() || _uiState.value.incrementsPerWorker.isEmpty() || _uiState.value.workersCount.toIntOrNull() == null || _uiState.value.incrementsPerWorker.toIntOrNull() == null ){
            _uiState.update {
                it.copy(status = CounterRaceStatus.Error)
            }
            return
        }
        val counterRaceParams = CounterRaceParams(
            workersCount = _uiState.value.workersCount.toInt(),
            incrementsPerWorker = _uiState.value.incrementsPerWorker.toInt(),
            mode = _uiState.value.selectedMode
        )

        _uiState.update {
            it.copy(status = CounterRaceStatus.Running)
        }
        viewModelScope.launch {
            try{
                val result = withContext(Dispatchers.Default) {
                    runCounterRaceUseCase(counterRaceParams)
                }
                _uiState.update {
                    it.copy(
                        actual = result.actual,
                        expected = result.expected,
                        lostUpdates = result.lostUpdates,
                        executionTime = result.executionTime,
                        status = CounterRaceStatus.Completed
                    )
                }
            }
            catch (e: CancellationException) {
                throw e
            } catch (_: Exception) {
                _uiState.update {
                    it.copy(
                        status = CounterRaceStatus.Error,
                        expected = 0,
                        lostUpdates = 0,
                        executionTime = 0,
                        actual = 0
                    )
                }
            }
        }
    }
}