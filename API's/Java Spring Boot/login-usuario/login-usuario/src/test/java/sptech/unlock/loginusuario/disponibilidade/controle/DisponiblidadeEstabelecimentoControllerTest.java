package sptech.unlock.loginusuario.disponibilidade.controle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import sptech.unlock.loginusuario.disponibilidade.entidade.DisponibilidadeEstabelecimento;
import sptech.unlock.loginusuario.disponibilidade.entidade.DisponibilidadeGrupoArtista;
import sptech.unlock.loginusuario.disponibilidade.repositorio.RepositorioDisponibilidadeEstabelecimento;
import sptech.unlock.loginusuario.estabelecimento.entidade.Estabelecimento;
import sptech.unlock.loginusuario.estabelecimento.repositorio.RepositorioEstabelecimento;
import sptech.unlock.loginusuario.grupoArtista.entidade.GrupoArtista;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {DisponiblidadeEstabelecimentoController.class})
class DisponiblidadeEstabelecimentoControllerTest {

    @Autowired
    DisponiblidadeEstabelecimentoController controller;

    @MockBean
    RepositorioDisponibilidadeEstabelecimento repository;

    @MockBean
    RepositorioEstabelecimento repositoryEst;

    @Test
    @DisplayName("PostDisponibilidade(): Adicionando uma Disponibilidade para um Úsuario (Aleatório)")
    void adicionandoDisponibilidadeGrupoArtistaExistente() {
        Estabelecimento estabelecimento = mock(Estabelecimento.class);
        DisponibilidadeEstabelecimento disponibilidade = mock(DisponibilidadeEstabelecimento.class);

        when(repositoryEst.save(new Estabelecimento())).thenReturn(new Estabelecimento());
        repositoryEst.save(estabelecimento);
        when(repositoryEst.findById(estabelecimento.getId())).thenReturn(Optional.of(estabelecimento));

        when(repository.findById(1)).thenReturn(Optional.of(disponibilidade));
        ResponseEntity<DisponibilidadeGrupoArtista> response = controller.postDisponibilidade(disponibilidade, estabelecimento.getId());
        assertEquals(201, response.getStatusCodeValue());
    }

    @Test
    @DisplayName("PostDisponibilidade(): Adicionando uma Disponibilidade para um Úsuario (Nulo)")
    void adicionandoDisponibilidadeGrupoArtistaInexistente() {
        Estabelecimento estabelecimento = mock(Estabelecimento.class);
        DisponibilidadeEstabelecimento disponibilidade = mock(DisponibilidadeEstabelecimento.class);

        when(repositoryEst.save(new Estabelecimento())).thenReturn(new Estabelecimento());
        repositoryEst.save(estabelecimento);
        when(repositoryEst.findById(estabelecimento.getId())).thenReturn(Optional.empty());

        when(repository.findById(1)).thenReturn(Optional.of(disponibilidade));
        ResponseEntity<DisponibilidadeGrupoArtista> response = controller.postDisponibilidade(disponibilidade, estabelecimento.getId());
        assertEquals(201, response.getStatusCodeValue());
    }

}