package com.app.transacao_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.transacao_api.business.services.EstatisticasService;
import com.app.transacao_api.dtos.EstatisticasResponseDTO;

import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/estatistica")
@RequiredArgsConstructor
public class EstatisticasController {

    private final EstatisticasService estatisticasService;

    @GetMapping
    @Operation(description = "Endpoint responsável por buscar estatísticas de transações")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca efetuada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na busca de estatísticas de transações"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<EstatisticasResponseDTO> buscarEstatisticas(
            @RequestParam(value = "intervaloBusca", required = false, defaultValue = "60") Integer intervaloBusca){
       return ResponseEntity.ok(
               estatisticasService.calcularEstatisticasTransacoes(intervaloBusca));
    }

}