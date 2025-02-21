package com.consultaodonto.consultaodonto.controller

import com.consultaodonto.consultaodonto.dto.DentistaDTO
import com.consultaodonto.consultaodonto.service.DentistaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/dentistas")
class DentistaController(
    @Autowired private val dentistaService: DentistaService
) {
    @PostMapping
    fun cadastrarDentista(@RequestBody dentistaDTO: DentistaDTO): DentistaDTO{
        return dentistaService.cadastrarDentista(dentistaDTO)
    }

    @GetMapping
    fun listarDentistas(): List<DentistaDTO>{
        return dentistaService.listarDentistas()
    }

    @GetMapping("/nome/{nome}")
    fun buscarDentistaPorNome(@PathVariable nome: String): List<DentistaDTO>{
        return  dentistaService.buscarDentistaPorNome(nome)
    }

    @GetMapping("/cro")
    fun buscarDentistaPorCro(@RequestParam cro: String): DentistaDTO{
        return dentistaService.buscarDentistaPorCro(cro)
    }

    @PutMapping("/{id}")
    fun atualizarDentista(@PathVariable id: String, @RequestBody dentistaDTO: DentistaDTO): DentistaDTO{
        return dentistaService.atualizarDentista(UUID.fromString(id), dentistaDTO)
    }

    @DeleteMapping("/{id}")
    fun deletarDentista(@PathVariable id: String){
        return dentistaService.deletarDentista(UUID.fromString(id))
    }
}