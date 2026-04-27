package com.example.parcial1pdm.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parcial1pdm.component.ProductCard
import com.example.parcial1pdm.data.menu
import com.example.parcial1pdm.viewmodel.OrderViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(
    onNavigateToOrder: () -> Unit,
    viewModel: OrderViewModel = viewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("menu") },
                actions = {
                    BadgedBox(
                        badge = {
                            if (viewModel.getTotalItemCount() > 0) {
                                Badge {
                                    Text(text = "${viewModel.getTotalItemCount()}")
                                }
                            }
                        }
                    ) {
                        IconButton(onClick = onNavigateToOrder) {
                            Icon(Icons.Default.ShoppingCart, contentDescription = "Ver Orden")
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(8.dp)
        ) {
            items(menu.size) { index ->
                val producto = menu[index]
                val cantidadEnOrden = viewModel.orderItems
                    .find { it.producto.id == producto.id }
                    ?.cantidad ?: 0

                ProductCard(
                    producto = producto,
                    cantidadEnOrden = cantidadEnOrden,
                    onProductClick = { viewModel.addProduct(producto) }
                )
            }
        }
    }
}