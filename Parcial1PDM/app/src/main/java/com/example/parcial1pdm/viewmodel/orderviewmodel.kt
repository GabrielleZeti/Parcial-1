package com.example.parcial1pdm.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.parcial1pdm.data.Producto
import com.example.parcial1pdm.model.OrderItem

class OrderViewModel : ViewModel() {
    private val _orderItems = mutableStateListOf<OrderItem>()
    val orderItems: List<OrderItem> = _orderItems

    fun addProduct(producto: Producto) {
        val existingItem = _orderItems.find { it.producto.id == producto.id }
        if (existingItem != null) {
            existingItem.cantidad++
        } else {
            _orderItems.add(OrderItem(producto, 1))
        }
    }

    fun removeProduct(productoId: Int) {
        _orderItems.removeAll { it.producto.id == productoId }
    }

    fun confirmOrder() {
        _orderItems.clear()
    }

    fun getTotalItemCount(): Int {
        return _orderItems.sumOf { it.cantidad }
    }

    fun getTotalPrice(): Double {
        return _orderItems.sumOf { it.subtotal }
    }
}