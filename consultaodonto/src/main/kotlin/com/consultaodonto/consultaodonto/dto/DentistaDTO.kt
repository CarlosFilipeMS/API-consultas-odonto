package com.consultaodonto.consultaodonto.dto

import java.util.UUID

data class DentistaDTO(
    val id: UUID? = null,
    val nome: String,
    val cro: String
)
