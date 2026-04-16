package com.project.concurrency.app.ui.screens.counter_race_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.concurrency.app.R
import com.project.concurrency.app.ui.screens.counter_race_screen.components.ActionSection
import com.project.concurrency.app.ui.screens.counter_race_screen.components.LogSection
import com.project.concurrency.app.ui.screens.counter_race_screen.components.ResultSection
import com.project.concurrency.app.ui.screens.counter_race_screen.components.SettingsSection
import com.project.concurrency.app.ui.screens.counter_race_screen.models.CounterRaceMode
import com.project.concurrency.app.ui.screens.counter_race_screen.models.CounterRaceUiState

@Composable
fun CounterRaceScreen(
    uiState: CounterRaceUiState,
    onWorkersCountChanged: (String) -> Unit,
    onIncrementsPerWorkerChanged: (String) -> Unit,
    onModeSelected: (CounterRaceMode) -> Unit,
    onRunClicked: () -> Unit,
    onResetClicked: () -> Unit,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = stringResource(R.string.counter_race),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(32.dp))
        SettingsSection(
            workersCount = uiState.workersCount,
            workersCountOnChange = onWorkersCountChanged,

            incrementsPerWorker = uiState.incrementsPerWorker,
            incrementsPerWorkerOnChange = onIncrementsPerWorkerChanged,

            selectedMode = uiState.selectedMode,
            selectedModeOnChange = onModeSelected
        )
        Spacer(Modifier.height(20.dp))
        ResultSection(
            expected = uiState.expected,
            actual = uiState.actual,
            lostUpdates = uiState.lostUpdates,
            executionTime = uiState.executionTime,
            status = uiState.status,
        )
        Spacer(Modifier.height(20.dp))
        ActionSection(
            onRunClick = onRunClicked,
            onResetClick = onResetClicked
        )
        Spacer(Modifier.height(20.dp))
        LogSection(
            text = uiState.logs
        )
    }
}