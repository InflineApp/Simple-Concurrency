package com.project.concurrency.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.project.concurrency.app.navigation.NavGraph
import com.project.concurrency.app.ui.theme.SimpleConcurrencyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()

            SimpleConcurrencyTheme {
                NavGraph(navController = navController)
            }
        }
    }
}