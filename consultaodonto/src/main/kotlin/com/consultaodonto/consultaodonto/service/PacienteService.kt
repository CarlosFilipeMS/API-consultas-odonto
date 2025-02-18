package com.consultaodonto.consultaodonto.service

import com.consultaodonto.consultaodonto.dto.PacienteDTO
import com.consultaodonto.consultaodonto.model.Paciente
import com.consultaodonto.consultaodonto.repository.PacienteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate
import java.util.*

@Service
class PacienteService(
    @Autowired private val pacienteRepository: PacienteRepository
) {

    @Transactional
    fun cadastrarPaciente(pacienteDTO: PacienteDTO): PacienteDTO {
        val paciente = Paciente(
            id = null, // O UUID será gerado automaticamente pelo banco de dados
            nome = pacienteDTO.nome,
            cpf = pacienteDTO.cpf,
            dataNascimento = LocalDate.parse(pacienteDTO.dataNascimento),
            telefone = pacienteDTO.telefone
        )

        try {
            val pacienteSalvo = pacienteRepository.save(paciente)
            return pacienteSalvo.toDTO()
        } catch (e: Exception) {
            throw IllegalStateException("Erro ao salvar o paciente: ${e.message}")
        }
    }

    @Transactional
    fun atualizarPaciente(id: UUID, pacienteDTO: PacienteDTO): PacienteDTO {
        val pacienteExistente = pacienteRepository.findById(id).orElseThrow {
            IllegalArgumentException("Paciente não encontrado")
        }

        val pacienteAtualizado = pacienteExistente.atualizar(
            nome = pacienteDTO.nome,
            cpf = pacienteDTO.cpf,
            dataNascimento = LocalDate.parse(pacienteDTO.dataNascimento),
            telefone = pacienteDTO.telefone
        )

        try {
            val pacienteSalvo = pacienteRepository.save(pacienteAtualizado)
            return pacienteSalvo.toDTO()
        } catch (e: Exception) {
            throw IllegalStateException("Erro ao atualizar o paciente: ${e.message}")
        }
    }

    fun buscarPacientePorId(id: UUID): PacienteDTO {
        val paciente = pacienteRepository.findById(id).orElseThrow {
            IllegalArgumentException("Paciente não encontrado")
        }
        return paciente.toDTO()
    }

    fun listarPacientes(): List<PacienteDTO> {
        val pacientes = pacienteRepository.findAll()
        return pacientes.map { it.toDTO() }
    }

    fun deletarPaciente(id: UUID) {
        pacienteRepository.deleteById(id)
    }
}
