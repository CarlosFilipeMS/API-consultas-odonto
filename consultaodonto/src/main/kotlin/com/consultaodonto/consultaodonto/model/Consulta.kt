package com.consultaodonto.consultaodonto.model

import com.consultaodonto.consultaodonto.dto.ConsultaDTO
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.UUID

@Entity
data class Consulta(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID? = null,

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    val paciente: Paciente,

    @ManyToOne
    @JoinColumn(name = "dentista_id", nullable = false)
    val dentista: Dentista,

    @Column(nullable = false)
    val dataHora: LocalDateTime
) {
    fun toDTO() = ConsultaDTO(
        id = this.id,
        pacienteId = this.paciente.id ?: UUID.randomUUID(),
        dentistaId = this.dentista.id ?: UUID.randomUUID(),
        dataHora = this.dataHora
    )
}
