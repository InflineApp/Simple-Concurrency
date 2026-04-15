package com.project.concurrency.app.navigation

sealed class Routes(val route: String) {
    object Home : Routes("home")
    object CounterRace : Routes("counter_race")
    object VisibilityStopFlag : Routes("visibility_stop_flag")
    object CancellationLab : Routes("cancellation_lab")
    object ExceptionLab : Routes("exception_lab")
    object FlowDashboard : Routes("flow_dashboard")
    object ProducerConsumer : Routes("producer_consumer")
}