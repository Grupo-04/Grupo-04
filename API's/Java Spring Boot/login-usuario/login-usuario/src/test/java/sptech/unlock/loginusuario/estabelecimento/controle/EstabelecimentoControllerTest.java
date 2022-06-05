package sptech.unlock.loginusuario.estabelecimento.controle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import sptech.unlock.loginusuario.email.service.EmailSenderService;
import sptech.unlock.loginusuario.estabelecimento.entidade.Estabelecimento;
import sptech.unlock.loginusuario.estabelecimento.repositorio.RepositorioEstabelecimento;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {EstabelecimentoController.class})
class EstabelecimentoControllerTest {

    @Autowired
    EstabelecimentoController controller;

    @MockBean
    private EmailSenderService senderService;

    @MockBean
    private RepositorioEstabelecimento repository;

    @Test
    @DisplayName("Cadastrar(): Adicionando um Estabelecimento (Válido)")
    void cadastrandoUmaEmpresaValida() {
        when(repository.save(new Estabelecimento())).thenReturn(new Estabelecimento());
        Integer response = controller.cadastrar(new Estabelecimento()).getStatusCodeValue();
        assertEquals(201, response);
    }

    @Test
    @DisplayName("Cadastrar(): Adicionando um Estabelecimento (Nulo)")
    void cadastrandoUmaEmpresaNula() {
        when(repository.save(null)).thenReturn(null);
        ResponseEntity<Estabelecimento> response = controller.cadastrar(null);
        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    @DisplayName("MatchCidade(): Enviando um ID Inexistente")
    void enviandoIdInexistente() {
        when(repository.findById(0)).thenReturn(null);
        ResponseEntity<Estabelecimento> response = controller.matchCidade(0);
        assertEquals(204, response.getStatusCodeValue());
    }

    @Test
    @DisplayName("MatchCidade(): Enviando um ID Existente")
    void enviandoIdExistente() {
        when(repository.findById(1)).thenReturn(new Estabelecimento());
        ResponseEntity<Estabelecimento> response = controller.matchCidade(1);
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    @DisplayName("ExibeTodos(): Exibindo Todos (Vazio)")
    void exibindoTodosEstabelecimentosDeveRetornar204() {
        when(repository.findAll()).thenReturn(new ArrayList<>());

        ResponseEntity<List<Estabelecimento>> response = controller.exibirTodos();
        assertEquals(204, response.getStatusCodeValue());
        assertNull(response.getBody());
    }

    @Test
    @DisplayName("ExibeTodos(): Exibindo Todos (Com Conteudo)")
    void exibindoTodosEstabelecimentosDeveRetornar200() {
        Estabelecimento estabelecimentoUm = mock(Estabelecimento.class);
        Estabelecimento estabelecimentoDois = mock(Estabelecimento.class);
        List<Estabelecimento> listMock = List.of(estabelecimentoUm, estabelecimentoDois);
        when(repository.findAll()).thenReturn(listMock);

        ResponseEntity<List<Estabelecimento>> response = controller.exibirTodos();
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(listMock, response.getBody());
    }

    @Test
    @DisplayName("Login(): Logando com um Usuario (Aleatório)")
    void loginUsuario() {
        when(repository.findByEmailAndSenha("enan.oliveira@bandtec.com.br",
                "12345")).thenReturn(new Estabelecimento());
        ResponseEntity<Estabelecimento> response = controller.login("enan.oliveira@bandtec.com.br", "12345");
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    @DisplayName("Login(): Logando com um Usuario (Nulo)")
    void loginUsuarioNulo() {
        when(repository.findByEmailAndSenha(null, null)).thenReturn(null);
        ResponseEntity<Estabelecimento> response = controller.login(null, null);
        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    @DisplayName("Logoff(): Logando com um Usuario (Aleatório)")
    void logoffUsuario() {
        when(repository.findByEmailAndSenha("enan.oliveira@bandtec.com.br",
                "12345")).thenReturn(new Estabelecimento());
        ResponseEntity<Estabelecimento> response = controller.logoff("enan.oliveira@bandtec.com.br", "12345");
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    @DisplayName("Logoff(): Logando com um Usuario (Nulo)")
    void logoffUsuarioNulo() {
        when(repository.findByEmailAndSenha(null, null)).thenReturn(null);
        ResponseEntity<Estabelecimento> response = controller.logoff(null, null);
        assertEquals(404, response.getStatusCodeValue());
    }

//    @Test
//    @DisplayName("Ajuda Felipao")
//    void felipe() {
//        Estabelecimento estabelecimento = mock(Estabelecimento.class);
//        when(repository.save(estabelecimento)).thenReturn(estabelecimento);
//        repository.save(estabelecimento);
//        when(repository.findByEmailAndSenha(estabelecimento.getEmail(), estabelecimento.getSenha()))
//                .thenReturn(estabelecimento);
//        ResponseEntity<Estabelecimento> response = controller.logoff(estabelecimento.getEmail(),
//                estabelecimento.getSenha());
//        assertEquals(200, response.getStatusCodeValue());
//    }

}