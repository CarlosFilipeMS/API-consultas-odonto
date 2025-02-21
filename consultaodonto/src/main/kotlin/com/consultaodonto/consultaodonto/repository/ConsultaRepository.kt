package com.consultaodonto.consultaodonto.repository

import com.consultaodonto.consultaodonto.model.Consulta
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ConsultaRepository: JpaRepository<Consulta, UUID> {
}