package com.app.transacao_api.business.services;

import java.util.DoubleSummaryStatistics;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.transacao_api.dtos.EstatisticasResponseDTO;
import com.app.transacao_api.dtos.TransacaoRequestDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstatisticasService {
	
	public final TransacaoService transactioService;
	
	public EstatisticasResponseDTO calcularEstatisticasTransacoes(Integer intervaloBusca) {
		List<TransacaoRequestDTO> transacoes = transactioService.buscarTransacoes(intervaloBusca);
		
		DoubleSummaryStatistics estatisticasTransacoes = transacoes.stream().mapToDouble(TransacaoRequestDTO::valor).summaryStatistics();
		
        return new EstatisticasResponseDTO(estatisticasTransacoes.getCount(),
                estatisticasTransacoes.getSum(),
                estatisticasTransacoes.getAverage(),
                estatisticasTransacoes.getMin(),
                estatisticasTransacoes.getMax());
	}
}
