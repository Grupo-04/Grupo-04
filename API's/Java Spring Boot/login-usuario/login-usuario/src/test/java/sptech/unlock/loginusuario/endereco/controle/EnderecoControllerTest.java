package sptech.unlock.loginusuario.endereco.controle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import sptech.unlock.loginusuario.email.service.EmailSenderService;
import sptech.unlock.loginusuario.endereco.entidade.Endereco;
import sptech.unlock.loginusuario.endereco.repositorio.RepositorioEndereco;
import sptech.unlock.loginusuario.estabelecimento.entidade.Estabelecimento;
import sptech.unlock.loginusuario.estabelecimento.repositorio.RepositorioEstabelecimento;
import sptech.unlock.loginusuario.grupoArtista.controle.GrupoArtistaController;
import sptech.unlock.loginusuario.grupoArtista.entidade.GrupoArtista;
import sptech.unlock.loginusuario.grupoArtista.repositorio.RepositorioGrupoArtista;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

@SpringBootTest(classes = {EnderecoController.class})
class EnderecoControllerTest {

    @Autowired
    EnderecoController controller;

    @MockBean
    private RepositorioEndereco repository;

    @Test
    @DisplayName("Teste get endereco")
    void getEndereco() {

        Endereco end = mock(Endereco.class);
        Endereco end1 = mock(Endereco.class);
        Endereco end2 = mock(Endereco.class);

        List<Endereco> listaMock = List.of(end,end1,end2);

        when(repository.findAll()).thenReturn(listaMock);

        ResponseEntity<List<Endereco>> resposta = controller.getEndereco();

        assertEquals(200, resposta.getStatusCodeValue());
    }

    @Test
    void cadastrarEndereco() {

        Endereco end = mock(Endereco.class);

        when(repository.save(end)).thenReturn(end);

        assertEquals(201, controller.cadastrarEndereco(end).getStatusCodeValue());

    }

    @Test
    @DisplayName("Teste atualizar endereco")
    void atualizaEndereco() {

        Endereco end = mock(Endereco.class);

        when(repository.save(end)).thenReturn(end);

        repository.save(end);

        when(end.getCep()).thenReturn("01001-000");
        when(end.getLogradouro()).thenReturn("Praça da Sé");
        when(end.getNumero()).thenReturn("1234");
        when(end.getBairro()).thenReturn("Sé");
        when(end.getCidade()).thenReturn("São Paulo");
        when(end.getUf()).thenReturn("SP");

        controller.atualizaEndereco(1,end);

        assertEquals("SP",end.getUf());

    }

//    @Test
//    void deleteEndereco() {
//
//        Endereco end = mock(Endereco.class);
//
//        when(repository.save(end)).thenReturn(end);
//
//        repository.save(end);
//
//        when(repository.deleteById()).thenReturn();
//
//        assertEquals(200, controller.deleteEndereco(1).getStatusCodeValue());
//
//        assertEquals(404, controller.deleteEndereco(2).getStatusCodeValue());
//
//    }
}