package com.app.transacao_api.business.services;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.transacao_api.dtos.TransacaoRequestDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransacaoService {
	private final List<TransacaoRequestDTO> listaTransacoes = new ArrayList<>();
	
	public void addTransacao(TransacaoRequestDTO dto) {
		
		
	}
}
