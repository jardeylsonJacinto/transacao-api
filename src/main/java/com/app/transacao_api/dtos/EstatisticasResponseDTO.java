package com.app.transacao_api.dtos;

public record EstatisticasResponseDTO(Long count,
        Double sum,
        Double avg,
        Double min,
        Double max) {

}