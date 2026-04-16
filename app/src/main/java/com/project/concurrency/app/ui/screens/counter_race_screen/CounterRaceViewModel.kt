package com.project.concurrency.app.ui.screens.counter_race_screen

import androidx.lifecycle.ViewModel
import com.project.concurrency.app.ui.screens.counter_race_screen.models.CounterRaceMode
import com.project.concurrency.app.ui.screens.counter_race_screen.models.CounterRaceStatus
import com.project.concurrency.app.ui.screens.counter_race_screen.models.CounterRaceUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CounterRaceViewModel : ViewModel() {

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
        _uiState.update {
            it.copy(status = CounterRaceStatus.Running)
        }
    }
}