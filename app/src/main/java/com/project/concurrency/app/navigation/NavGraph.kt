package com.project.concurrency.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.project.concurrency.app.ui.screens.CancellationLabScreen
import com.project.concurrency.app.ui.screens.counter_race_screen.CounterRaceScreen
import com.project.concurrency.app.ui.screens.ExceptionLabScreen
import com.project.concurrency.app.ui.screens.FlowDashboardScreen
import com.project.concurrency.app.ui.screens.home_screen.HomeScreen
import com.project.concurrency.app.ui.screens.ProducerConsumerScreen
import com.project.concurrency.app.ui.screens.VisibilityStopFlagScreen
import com.project.concurrency.app.ui.screens.counter_race_screen.CounterRaceRoute

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Home.route
    ) {
        composable(Routes.Home.route) {
            HomeScreen(
                onClickCounterRace = {
                    navController.navigate(Routes.CounterRace.route)
                },
                onClickVisibilityStopFlag = {
                    navController.navigate(Routes.VisibilityStopFlag.route)
                },
                onClickCancellationLab = {
                    navController.navigate(Routes.CancellationLab.route)
                },
                onClickExceptionLab = {
                    navController.navigate(Routes.ExceptionLab.route)
                },
                onClickFlowDashboard = {
                    navController.navigate(Routes.FlowDashboard.route)
                },
                onClickProducerConsumer = {
                    navController.navigate(Routes.ProducerConsumer.route)
                }
            )
        }

        composable(Routes.CounterRace.route) {
            CounterRaceRoute()
        }

        composable(Routes.VisibilityStopFlag.route) {
            VisibilityStopFlagScreen()
        }

        composable(Routes.CancellationLab.route) {
            CancellationLabScreen()
        }

        composable(Routes.ExceptionLab.route) {
            ExceptionLabScreen()
        }

        composable(Routes.FlowDashboard.route) {
            FlowDashboardScreen()
        }

        composable(Routes.ProducerConsumer.route) {
            ProducerConsumerScreen()
        }
    }
}