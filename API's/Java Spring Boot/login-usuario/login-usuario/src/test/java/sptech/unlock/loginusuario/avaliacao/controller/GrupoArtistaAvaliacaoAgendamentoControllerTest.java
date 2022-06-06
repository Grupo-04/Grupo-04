package sptech.unlock.loginusuario.avaliacao.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import sptech.unlock.loginusuario.avaliacao.entidade.EstabelecimentoAvaliacaoAgendamento;
import sptech.unlock.loginusuario.avaliacao.entidade.GrupoArtistaAvaliacaoAgendamento;
import sptech.unlock.loginusuario.avaliacao.repositorio.RepositorioEstabelecimentoAvaliacaoAgendamento;
import sptech.unlock.loginusuario.avaliacao.repositorio.RepositorioGrupoArtistaAvaliacaoAgendamento;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {GrupoArtistaAvaliacaoAgendamentoController.class})
class GrupoArtistaAvaliacaoAgendamentoControllerTest {

    @Autowired
    GrupoArtistaAvaliacaoAgendamentoController controller;

    @MockBean
    private RepositorioGrupoArtistaAvaliacaoAgendamento repository;

    @Test
    @DisplayName("Testes get avaliações")
    void getAvaliacaoEstabelecimento() {

        GrupoArtistaAvaliacaoAgendamento grupo = mock(GrupoArtistaAvaliacaoAgendamento.class);

        when(repository.save(grupo)).thenReturn(grupo);

        repository.save(grupo);

        List<GrupoArtistaAvaliacaoAgendamento> lista = List.of(grupo);

        when(repository.findAll()).thenReturn(lista);

        assertEquals(200, controller.getAvaliacaoEstabelecimento().getStatusCodeValue());
    }

    @Test
    @DisplayName("Testes get avaliações vazio")
    void getAvaliacaoEstabelecimentoVazio() {

        when(repository.findAll()).thenReturn(new ArrayList<GrupoArtistaAvaliacaoAgendamento>());

        assertEquals(204, controller.getAvaliacaoEstabelecimento().getStatusCodeValue());
    }

    @Test
    @DisplayName("Teste criar avaliação grupo artista")
    void avaliar() {

        GrupoArtistaAvaliacaoAgendamento grupo = mock(GrupoArtistaAvaliacaoAgendamento.class);

        when(repository.save(grupo)).thenReturn(grupo);

        assertEquals(201, controller.avaliar(grupo).getStatusCodeValue());
    }

    @Test
    @DisplayName("Teste atualizar avaliacao")
    void atualizar() {

        GrupoArtistaAvaliacaoAgendamento grupo = mock(GrupoArtistaAvaliacaoAgendamento.class);

        when(repository.save(grupo)).thenReturn(grupo);

        assertEquals(201, controller.avaliar(grupo).getStatusCodeValue());
    }

    @Test
    @DisplayName("Teste atualizar avaliacao com avaliacao null")
    void atualizarAvaliacaoNull() {

        GrupoArtistaAvaliacaoAgendamento grupo = mock(GrupoArtistaAvaliacaoAgendamento.class);

        when(repository.save(grupo)).thenReturn(grupo);

        repository.save(grupo);

        when(grupo.getComentario()).thenReturn("Muito bom");
        when(grupo.getNota()).thenReturn(4.5);

        assertEquals(400,controller.atualizar(1,null).getStatusCodeValue());
    }

    @Test
    @DisplayName("Teste atualizar avaliacao com id null")
    void atualizarIdNull() {

        GrupoArtistaAvaliacaoAgendamento grupo = mock(GrupoArtistaAvaliacaoAgendamento.class);

        when(repository.save(grupo)).thenReturn(grupo);

        repository.save(grupo);

        when(grupo.getComentario()).thenReturn("Muito bom");
        when(grupo.getNota()).thenReturn(4.5);

        assertEquals(400,controller.atualizar(null,grupo).getStatusCodeValue());
    }

    @Test
    @DisplayName("Teste atualizar avaliacao com id e avaliacao null")
    void atualizarIdEAvaliacaoNull() {

        GrupoArtistaAvaliacaoAgendamento grupo = mock(GrupoArtistaAvaliacaoAgendamento.class);

        when(repository.save(grupo)).thenReturn(grupo);

        repository.save(grupo);

        when(grupo.getComentario()).thenReturn("Muito bom");
        when(grupo.getNota()).thenReturn(4.5);

        assertEquals(400,controller.atualizar(null, null).getStatusCodeValue());
    }


//    @Test
//    void deleteAvaliacaoGrupoArtista() {
//    }
//
//    @Test
//    void empilharAvaliacao() {
//    }
//
//    @Test
//    void getPilhaGrupoArtistaAvaliacaoAtendimento() {
//    }
//
//    @Test
//    void getUltimoEmpilhado() {
//    }
}