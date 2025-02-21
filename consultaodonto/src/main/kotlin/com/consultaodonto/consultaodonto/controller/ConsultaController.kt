package com.consultaodonto.consultaodonto.controller

import com.consultaodonto.consultaodonto.dto.ConsultaDTO
import com.consultaodonto.consultaodonto.service.ConsultaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/consultas")
class ConsultaController(
    @Autowired private val consultaService: ConsultaService
) {
    @PostMapping
    fun marcarConsulta(@RequestBody consultaDTO: ConsultaDTO): ConsultaDTO{
        return consultaService.marcarConsulta(consultaDTO)
    }
}