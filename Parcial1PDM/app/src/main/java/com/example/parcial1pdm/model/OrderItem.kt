package com.example.parcial1pdm.model

import com.example.parcial1pdm.data.Producto

data class OrderItem(
    val producto: Producto,
    var cantidad: Int
) {
    val subtotal: Double
        get() = producto.precio * cantidad
}