package sptech.unlock.loginusuario.agendamento.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import sptech.unlock.loginusuario.agendamento.entidade.Agendamento;
import sptech.unlock.loginusuario.agendamento.repositorio.RepositorioAgendamento;
import sptech.unlock.loginusuario.estabelecimento.entidade.Estabelecimento;
import sptech.unlock.loginusuario.estabelecimento.repositorio.RepositorioEstabelecimento;
import sptech.unlock.loginusuario.filaobj.FilaObj;
import sptech.unlock.loginusuario.grupoArtista.entidade.GrupoArtista;
import sptech.unlock.loginusuario.grupoArtista.repositorio.RepositorioGrupoArtista;
import sptech.unlock.loginusuario.listaobj.ListaObj;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDateTime.now;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {AgendamentoController.class})
class AgendamentoControllerTest {

    @Autowired
    AgendamentoController controller;

    @MockBean
    RepositorioAgendamento repository;

    @MockBean
    RepositorioGrupoArtista repositorioArt;

    @MockBean
    RepositorioEstabelecimento repositorioEst;

    @Test
    @DisplayName("AdicionaAgendamento(): Adicionando um Agendamento")
    void adicionarAgendamento() {
        Agendamento agendamento = mock(Agendamento.class);
        GrupoArtista artista = mock((GrupoArtista.class));
        Estabelecimento estabelecimento = mock(Estabelecimento.class);
        when(repository.save(new Agendamento())).thenReturn(agendamento);
        ResponseEntity<Agendamento> response = controller.adicionarAgendamento(agendamento, artista.getId(), estabelecimento.getId());
        assertEquals(201, response.getStatusCodeValue());
    }

    @Test
    void enfileirarAgendamento() {
        Agendamento agendamento1 = mock(Agendamento.class);
        Agendamento agendamento2 = mock(Agendamento.class);
        Agendamento agendamento3 = mock(Agendamento.class);
        Agendamento agendamento4 = mock(Agendamento.class);
        Agendamento agendamento5 = mock(Agendamento.class);
        List<Agendamento> lista = new ArrayList<>(5);
        lista.add(agendamento1);
        lista.add(agendamento2);
        lista.add(agendamento3);
        lista.add(agendamento4);
        lista.add(agendamento5);
        FilaObj<Agendamento> response = controller.enfileirarAgendamento(lista);

        assertEquals(agendamento1, response.peek());
    }

    @Test
    void getFilaAgendamento() {
        Agendamento agendamento = mock(Agendamento.class);
        Agendamento agendamento1 = mock(Agendamento.class);
        Agendamento agendamento2 = mock(Agendamento.class);
        List<Agendamento> MockList = List.of(agendamento, agendamento1, agendamento2);
        when(repository.findAll()).thenReturn(MockList);
        ResponseEntity<Agendamento> response = controller.getFilaAgendamento();
        assertEquals(200, response.getStatusCodeValue());
    }

    // @Test
    // void getPrimeiroEmpilhado() {
    //     assertEquals(1, 2);
    // }

    @Test
    void getAgendamentos() {
        Agendamento agendamento = mock(Agendamento.class);
        Agendamento agendamento1 = mock(Agendamento.class);
        Agendamento agendamento2 = mock(Agendamento.class);
        List<Agendamento> MockList = List.of(agendamento, agendamento1, agendamento2);
        when(repository.findAll()).thenReturn(MockList);
        ResponseEntity<Agendamento> response = controller.getAgendamentos();
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void consultarPorData() {
        Agendamento agendamento = new Agendamento(1, "A1B2C3", "Em andamento...",
                LocalDateTime.of(2022, 6, 1, 14, 30, 0), 200.0);
        Agendamento agendamento1 = new Agendamento(2, "3C2B1A", "Aguardando...",
                LocalDateTime.of(2022, 9, 13, 20, 0, 0), 200.0);
        Agendamento agendamento2 = new Agendamento(3, "ABC123", "Em andamento...",
                LocalDateTime.of(2022, 10, 22, 22, 40, 0), 200.0);
        List<Agendamento> lista = new ArrayList<>(3);
        lista.add(agendamento);
        lista.add(agendamento1);
        lista.add(agendamento2);

        when(repository.findAll()).thenReturn(lista);
        ResponseEntity<Agendamento> response = controller.consultarPorData(
                LocalDateTime.of(2022, 9, 13, 20, 0, 0));
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void atualizarAgendamento() {
        Agendamento agendamento = new Agendamento(1, "A1B2C3", "Em andamento...",
                LocalDateTime.of(2022, 6, 1, 14, 30, 0), 200.0);
        Agendamento agendamento1 = new Agendamento(2, "3C2B1A", "Aguardando...",
                LocalDateTime.of(2022, 9, 13, 20, 0, 0), 200.0);
        Agendamento agendamento2 = new Agendamento(3, "ABC123", "Em andamento...",
                LocalDateTime.of(2022, 10, 22, 22, 40, 0), 200.0);
        List<Agendamento> lista = new ArrayList<>(3);
        lista.add(agendamento);
        lista.add(agendamento1);
        lista.add(agendamento2);

        when(repository.findAll()).thenReturn(lista);
        ResponseEntity<Agendamento> response = controller.atualizarAgendamento("3C2B1A", now());
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void ataulizarValorCobrado() {
        Agendamento agendamento = new Agendamento(1, "A1B2C3", "Em andamento...",
                LocalDateTime.of(2022, 6, 1, 14, 30, 0), 20.0);
        Agendamento agendamento1 = new Agendamento(2, "3C2B1A", "Aguardando...",
                LocalDateTime.of(2022, 9, 13, 20, 0, 0), 100.0);
        Agendamento agendamento2 = new Agendamento(3, "ABC123", "Em andamento...",
                LocalDateTime.of(2022, 10, 22, 22, 40, 0), 80.0);
        List<Agendamento> lista = new ArrayList<>(3);
        lista.add(agendamento);
        lista.add(agendamento1);
        lista.add(agendamento2);


        when(repository.findAll()).thenReturn(lista);
        ResponseEntity<Agendamento> response = controller.atualizarValorCobrado(200.0, "A1B2C3");
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void cancelarAgendamento() {
        Agendamento agendamento = new Agendamento(1, "A1B2C3", "Em andamento...",
                LocalDateTime.of(2022, 6, 1, 14, 30, 0), 20.0);
        Agendamento agendamento1 = new Agendamento(2, "3C2B1A", "Aguardando...",
                LocalDateTime.of(2022, 9, 13, 20, 0, 0), 100.0);
        Agendamento agendamento2 = new Agendamento(3, "ABC123", "Em andamento...",
                LocalDateTime.of(2022, 10, 22, 22, 40, 0), 80.0);
        List<Agendamento> lista = new ArrayList<>(3);
        lista.add(agendamento);
        lista.add(agendamento1);
        lista.add(agendamento2);

        when(repository.findAll()).thenReturn(lista);
        ResponseEntity<Agendamento> response = controller.cancelarAgendamento("ABC123");
        assertEquals(200, response.getStatusCodeValue());
    }
}