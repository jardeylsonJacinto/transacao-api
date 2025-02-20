package com.app.transacao_api.business.service;


import com.app.transacao_api.business.services.TransacaoService;
import com.app.transacao_api.dtos.EstatisticasResponseDTO;
import com.app.transacao_api.dtos.TransacaoRequestDTO;
import com.app.transacao_api.infra.exceptions.UnprocessableEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TransacaoServiceTest {

    @InjectMocks
    TransacaoService transacaoService;

    TransacaoRequestDTO transacao;

    EstatisticasResponseDTO estatisticas;

    @BeforeEach
    void setUp(){
        transacao = new TransacaoRequestDTO(20.0, OffsetDateTime.now());
        estatisticas = new EstatisticasResponseDTO(1l, 20.0, 20.0, 20.0, 20.0);
    }

    @Test
    void deveAdicionarTransacaoComSucesso(){

        transacaoService.addTransacao(transacao);

        List<TransacaoRequestDTO> transacoes = transacaoService.buscarTransacoes(5000);

        assertTrue(transacoes.contains(transacao));
    }

    @Test
    void deveLancarExcecaoCasoValorSejaNegativo(){

        UnprocessableEntity exception = assertThrows(UnprocessableEntity.class,
                () -> transacaoService.addTransacao(new TransacaoRequestDTO(-10.0, OffsetDateTime.now())));

        assertEquals("Valor não pode ser menor que 0", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoCasoDataOuHoraMaiorQueAtual(){

        UnprocessableEntity exception = assertThrows(UnprocessableEntity.class,
                () -> transacaoService.addTransacao(new TransacaoRequestDTO(10.0, OffsetDateTime.now().plusDays(1))));

        assertEquals("Data e hora maiores que a data e hora atuais", exception.getMessage());
    }

    @Test
    void deveLimparTransacaoComSucesso(){

        transacaoService.limparTransacoes();

        List<TransacaoRequestDTO> transacoes = transacaoService.buscarTransacoes(5000);

        assertTrue(transacoes.isEmpty());
    }

    @Test
    void deveBuscarTransacaoDentroDoIntervalo(){

        TransacaoRequestDTO dto = new TransacaoRequestDTO(10.00, OffsetDateTime.now().minusHours(1));

        transacaoService.addTransacao(transacao);
        transacaoService.addTransacao(dto);

        List<TransacaoRequestDTO> transacoes = transacaoService.buscarTransacoes(60);

        assertTrue(transacoes.contains(transacao));
        assertFalse(transacoes.contains(dto));
    }




}