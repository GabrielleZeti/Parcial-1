package com.example.parcial1pdm.data

data class Producto(
    val id: Int,
    val nombre: String,
    val precio: Double,
    val imagenUrl: String,
    val tipo: TipoProducto
)
enum class TipoProducto {
    PUPUSA,
    BEBIDA
}