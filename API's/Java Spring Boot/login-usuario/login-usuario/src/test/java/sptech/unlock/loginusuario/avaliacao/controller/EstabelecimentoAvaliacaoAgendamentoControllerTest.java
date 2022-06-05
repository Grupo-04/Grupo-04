package sptech.unlock.loginusuario.avaliacao.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import sptech.unlock.loginusuario.avaliacao.entidade.EstabelecimentoAvaliacaoAgendamento;
import sptech.unlock.loginusuario.avaliacao.repositorio.RepositorioEstabelecimentoAvaliacaoAgendamento;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

@SpringBootTest(classes = {EstabelecimentoAvaliacaoAgendamentoController.class})
class EstabelecimentoAvaliacaoAgendamentoControllerTest {

    @Autowired
    EstabelecimentoAvaliacaoAgendamentoController controller;

    @MockBean
    private RepositorioEstabelecimentoAvaliacaoAgendamento repository;

    @Test
    @DisplayName("Testes get avaliações")
    void getAvaliacaoEstabelecimento() {

        EstabelecimentoAvaliacaoAgendamento estab = mock(EstabelecimentoAvaliacaoAgendamento.class);

        when(repository.save(estab)).thenReturn(estab);

        repository.save(estab);

        List<EstabelecimentoAvaliacaoAgendamento> lista = List.of(estab);

        when(repository.findAll()).thenReturn(lista);

        assertEquals(200, controller.getAvaliacaoEstabelecimento().getStatusCodeValue());
    }

    @Test
    @DisplayName("Testes get avaliações vazio")
    void getAvaliacaoEstabelecimentoVazio() {

        when(repository.findAll()).thenReturn(new ArrayList<EstabelecimentoAvaliacaoAgendamento>());

        assertEquals(204, controller.getAvaliacaoEstabelecimento().getStatusCodeValue());
    }

    @Test
    @DisplayName("Teste criar avaliação estabelecimento")
    void avaliar() {

        EstabelecimentoAvaliacaoAgendamento estab = mock(EstabelecimentoAvaliacaoAgendamento.class);

        when(repository.save(estab)).thenReturn(estab);

        assertEquals(201, controller.avaliar(estab).getStatusCodeValue());
    }

    @Test
    @DisplayName("Teste atualizar avaliacao")
    void atualizar() {

        EstabelecimentoAvaliacaoAgendamento estab = mock(EstabelecimentoAvaliacaoAgendamento.class);

        when(repository.save(estab)).thenReturn(estab);

        repository.save(estab);

        when(estab.getComentario()).thenReturn("Muito bom");
        when(estab.getNota()).thenReturn(4.5);

        controller.atualizar(1,estab);

        assertEquals(4.5,estab.getNota());

    }

    @Test
    @DisplayName("Teste atualizar avaliacao com avaliacao null")
    void atualizarAvaliacaoNull() {

        EstabelecimentoAvaliacaoAgendamento estab = mock(EstabelecimentoAvaliacaoAgendamento.class);

        when(repository.save(estab)).thenReturn(estab);

        repository.save(estab);

        when(estab.getComentario()).thenReturn("Muito bom");
        when(estab.getNota()).thenReturn(4.5);

        assertEquals(400,controller.atualizar(1,null).getStatusCodeValue());
    }

    @Test
    @DisplayName("Teste atualizar avaliacao com id null")
    void atualizarIdNull() {

        EstabelecimentoAvaliacaoAgendamento estab = mock(EstabelecimentoAvaliacaoAgendamento.class);

        when(repository.save(estab)).thenReturn(estab);

        repository.save(estab);

        when(estab.getComentario()).thenReturn("Muito bom");
        when(estab.getNota()).thenReturn(4.5);

        assertEquals(400,controller.atualizar(null,estab).getStatusCodeValue());
    }

    @Test
    @DisplayName("Teste atualizar avaliacao com id e avaliacao null")
    void atualizarIdEAvaliacaoNull() {

        EstabelecimentoAvaliacaoAgendamento estab = mock(EstabelecimentoAvaliacaoAgendamento.class);

        when(repository.save(estab)).thenReturn(estab);

        repository.save(estab);

        when(estab.getComentario()).thenReturn("Muito bom");
        when(estab.getNota()).thenReturn(4.5);

        assertEquals(400,controller.atualizar(null, null).getStatusCodeValue());
    }

//    @Test
//    void apagarAvaliacao() {
//    }

//    @Test
//    void empilharAvaliacao() {
//    }
//
//    @Test
//    void getPilhaEstabelecimentoAvaliacaoAgendamento() {
//    }
//
//    @Test
//    void getUltimoEmpilhado() {
//    }
}