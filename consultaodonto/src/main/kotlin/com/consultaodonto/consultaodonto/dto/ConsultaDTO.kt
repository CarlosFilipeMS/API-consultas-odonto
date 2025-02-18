package com.consultaodonto.consultaodonto.dto

import java.time.LocalDateTime
import java.util.UUID

data class ConsultaDTO(
    val id: UUID? = null,
    val pacienteId: UUID,
    val dentistaId: UUID,
    val dataHora: LocalDateTime
)
