package com.example.parcial1pdm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parcial1pdm.screen.MenuScreen
import com.example.parcial1pdm.screen.OrderScreen
import com.example.parcial1pdm.ui.theme.Parcial1PDMTheme
import com.example.parcial1pdm.viewmodel.OrderViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Parcial1PDMTheme {
                OrderUpApp()
            }
        }
    }
}

@Composable
fun OrderUpApp() {
    val viewModel: OrderViewModel = viewModel()
    var showOrderScreen by remember { mutableStateOf(false) }

    if (showOrderScreen) {
        OrderScreen(
            onNavigateBack = { showOrderScreen = false },
            onOrderConfirmed = {
                showOrderScreen = false
            },
            viewModel = viewModel
        )
    } else {
        MenuScreen(
            onNavigateToOrder = { showOrderScreen = true },
            viewModel = viewModel
        )
    }
}