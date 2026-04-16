package com.project.concurrency.app.ui.screens.counter_race_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.concurrency.app.R
import com.project.concurrency.app.ui.screens.counter_race_screen.models.CounterRaceStatus

@Composable
fun ResultSection(
    expected: Int,
    actual: Int,
    lostUpdates: Int,
    executionTime: Long?,
    status: CounterRaceStatus,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.result),
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(8.dp))
        val expectedText = stringResource(R.string.expected) + ": $expected"
        Text(
            text = expectedText,
            fontSize = 16.sp,
            color = Color.Black,
        )

        Spacer(Modifier.height(4.dp))
        val actualText = stringResource(R.string.actual) + ": $actual"
        Text(
            text = actualText,
            fontSize = 16.sp,
            color = Color.Black,
        )

        Spacer(Modifier.height(4.dp))
        val lostUpdatesText = stringResource(R.string.lost_updates) + ": $lostUpdates"
        Text(
            text = lostUpdatesText,
            fontSize = 16.sp,
            color = Color.Black,
        )

        Spacer(Modifier.height(4.dp))
        val executionTimeText = stringResource(R.string.execution_time) + ": $executionTime"
        Text(
            text = executionTimeText,
            fontSize = 16.sp,
            color = Color.Black,
        )

        Spacer(Modifier.height(4.dp))
        val statusText = stringResource(R.string.status) + ": $status"
        Text(
            text = statusText,
            fontSize = 16.sp,
            color = Color.Black,
        )
    }
}