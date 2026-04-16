package com.project.concurrency.app.ui.screens.counter_race_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CounterRaceRoute(
    viewModel: CounterRaceViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    CounterRaceScreen(
        uiState = uiState,
        onWorkersCountChanged = viewModel::onWorkersCountChanged,
        onIncrementsPerWorkerChanged = viewModel::onIncrementsPerWorkerChanged,
        onModeSelected = viewModel::onModeSelected,
        onRunClicked = viewModel::onRunClicked,
        onResetClicked = viewModel::onResetClicked
    )
}