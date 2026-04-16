package com.project.concurrency.app.ui.screens.counter_race_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.concurrency.app.R
import com.project.concurrency.app.ui.components.SimpleChip
import com.project.concurrency.app.ui.components.SimpleChipSingleSelect
import com.project.concurrency.app.ui.components.SimpleTextField
import com.project.concurrency.app.ui.screens.counter_race_screen.models.CounterRaceMode

@Composable
fun SettingsSection(
    workersCount: String,
    workersCountOnChange: (String) -> Unit,

    incrementsPerWorker: String,
    incrementsPerWorkerOnChange: (String) -> Unit,

    selectedMode: CounterRaceMode,
    selectedModeOnChange: (CounterRaceMode) -> Unit,
) {
    val modeList = CounterRaceMode.entries.toList()

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.settings),
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(8.dp))
        SimpleTextField(
            value = workersCount,
            onValueChange = workersCountOnChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = stringResource(R.string.workers_count),
            modifier = Modifier.fillMaxWidth()
        )
        SimpleTextField(
            value = incrementsPerWorker,
            onValueChange = incrementsPerWorkerOnChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = stringResource(R.string.increments_per_worker),
            modifier = Modifier.fillMaxWidth()
        )

        SimpleChipSingleSelect(
            optionsList = modeList,
            selectedOption = selectedMode,
            onSelectedOptionChange = selectedModeOnChange,
            label = { it.title },
            modifier = Modifier.fillMaxWidth(),
        )
    }
}