package com.project.concurrency.app.ui.screens.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.concurrency.app.R
import com.project.concurrency.app.ui.theme.Blue
import com.project.concurrency.app.ui.theme.Green
import com.project.concurrency.app.ui.theme.Orange
import com.project.concurrency.app.ui.theme.Purple
import com.project.concurrency.app.ui.theme.Red
import com.project.concurrency.app.ui.theme.Yellow

@Composable
fun HomeScreen(
    onClickCounterRace: () -> Unit,
    onClickVisibilityStopFlag: () -> Unit,
    onClickCancellationLab: () -> Unit,
    onClickExceptionLab: () -> Unit,
    onClickFlowDashboard: () -> Unit,
    onClickProducerConsumer: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(R.string.app_name),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(32.dp))
        HomeCard(
            title = stringResource(R.string.counter_race),
            description = stringResource(R.string.counter_race_description),
            color = Red,
            onClick = onClickCounterRace
        )
        Spacer(Modifier.height(8.dp))
        HomeCard(
            title = stringResource(R.string.visibility_stop_flag),
            description = stringResource(R.string.visibility_stop_flag_description),
            color = Orange,
            onClick = onClickVisibilityStopFlag
        )
        Spacer(Modifier.height(8.dp))
        HomeCard(
            title = stringResource(R.string.cancellation_lab),
            description = stringResource(R.string.cancellation_lab_description),
            color = Yellow,
            onClick = onClickCancellationLab
        )
        Spacer(Modifier.height(8.dp))
        HomeCard(
            title = stringResource(R.string.exception_lab),
            description = stringResource(R.string.exception_lab_description),
            color = Purple,
            onClick = onClickExceptionLab
        )
        Spacer(Modifier.height(8.dp))
        HomeCard(
            title = stringResource(R.string.flow_dashboard),
            description = stringResource(R.string.flow_dashboard_description),
            color = Blue,
            onClick = onClickFlowDashboard
        )
        Spacer(Modifier.height(8.dp))
        HomeCard(
            title = stringResource(R.string.producer_consumer),
            description = stringResource(R.string.producer_consumer_description),
            color = Green,
            onClick = onClickProducerConsumer
        )
    }
}

@Composable
@Preview
fun HomeScreenPreview(){
    HomeScreen(
        {},
        {},
        {},
        {},
        {},
        {}
    )
}