package com.consultaodonto.consultaodonto.model

import com.consultaodonto.consultaodonto.dto.DentistaDTO
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.UUID

@Entity
data class Dentista(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: UUID? = null,

    @Column(nullable = false)
    val nome: String,

    @Column(nullable = false, unique = true)
    val cro: String
) {

    fun toDTO() = DentistaDTO(
        id = this.id,
        nome = this.nome,
        cro = this.cro
    )
}