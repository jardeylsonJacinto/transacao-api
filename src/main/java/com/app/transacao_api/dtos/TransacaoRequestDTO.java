package com.app.transacao_api.dtos;

import java.time.OffsetDateTime;

public record TransacaoRequestDTO(Double value, OffsetDateTime dataHora) {

}
