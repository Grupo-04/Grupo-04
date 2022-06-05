package sptech.unlock.loginusuario.disponibilidade.controle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import sptech.unlock.loginusuario.disponibilidade.entidade.DisponibilidadeGrupoArtista;
import sptech.unlock.loginusuario.disponibilidade.repositorio.RepositorioDisponibilidadeGrupoArtista;
import sptech.unlock.loginusuario.grupoArtista.entidade.GrupoArtista;
import sptech.unlock.loginusuario.grupoArtista.repositorio.RepositorioGrupoArtista;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {DisponibilidadeGrupoArtistaController.class})
class DisponibilidadeGrupoArtistaControllerTest {

    @Autowired
    DisponibilidadeGrupoArtistaController controller;

    @MockBean
    RepositorioDisponibilidadeGrupoArtista repository;

    @MockBean
    RepositorioGrupoArtista repositorioArtista;

    @Test
    @DisplayName("PostDisponibilidade(): Adicionando uma Disponibilidade para um Úsuario (Aleatório)")
    void adicionandoDisponibilidadeGrupoArtistaExistente() {
        GrupoArtista artista = mock(GrupoArtista.class);
        DisponibilidadeGrupoArtista disponibilidade = mock(DisponibilidadeGrupoArtista.class);

        when(repositorioArtista.save(new GrupoArtista())).thenReturn(new GrupoArtista());
        repositorioArtista.save(artista);
        when(repositorioArtista.findById(artista.getId())).thenReturn(Optional.of(artista));

        when(repository.findById(1)).thenReturn(Optional.of(disponibilidade));
        ResponseEntity<DisponibilidadeGrupoArtista> response = controller.postDisponibilidade(disponibilidade, artista.getId());
        assertEquals(201, response.getStatusCodeValue());
    }

    @Test
    @DisplayName("PostDisponibilidade(): Adicionando uma Disponibilidade para um Úsuario (Nulo)")
    void adicionandoDisponibilidadeGrupoArtistaNulo() {
        GrupoArtista artista = mock(GrupoArtista.class);
        DisponibilidadeGrupoArtista disponibilidade = mock(DisponibilidadeGrupoArtista.class);

        when(repositorioArtista.save(new GrupoArtista())).thenReturn(new GrupoArtista());
        repositorioArtista.save(artista);
        when(repositorioArtista.findById(artista.getId())).thenReturn(Optional.empty());

        when(repository.findById(1)).thenReturn(Optional.of(disponibilidade));
        ResponseEntity<DisponibilidadeGrupoArtista> response = controller.postDisponibilidade(disponibilidade, artista.getId());
        assertEquals(201, response.getStatusCodeValue());
    }

}