package com.consultaodonto.consultaodonto.service

import com.consultaodonto.consultaodonto.dto.ConsultaDTO
import com.consultaodonto.consultaodonto.model.Consulta
import com.consultaodonto.consultaodonto.repository.ConsultaRepository
import com.consultaodonto.consultaodonto.repository.DentistaRepository
import com.consultaodonto.consultaodonto.repository.PacienteRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ConsultaService(
    private val consultaRepository: ConsultaRepository,
    private val pacienteRepository: PacienteRepository,
    private val dentistaRepository: DentistaRepository
) {
    @Transactional
    fun marcarConsulta(consultaDTO: ConsultaDTO): ConsultaDTO{
        val paciente = pacienteRepository.findById
        val consulta = Consulta(
            id = null,
            paciente = consultaDTO.pacienteId,
            dentista = consultaDTO.dentistaId,
            dataHora = consultaDTO.dataHora
        )
    }
}