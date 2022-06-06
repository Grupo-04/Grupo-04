package sptech.unlock.loginusuario.grupoArtista.controle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import sptech.unlock.loginusuario.email.service.EmailSenderService;
import sptech.unlock.loginusuario.endereco.entidade.Endereco;
import sptech.unlock.loginusuario.estabelecimento.repositorio.RepositorioEstabelecimento;
import sptech.unlock.loginusuario.grupoArtista.entidade.GrupoArtista;
import sptech.unlock.loginusuario.grupoArtista.repositorio.RepositorioGrupoArtista;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

@SpringBootTest(classes = {GrupoArtistaController.class})
class GrupoArtistaControllerTest {

    @Autowired
    GrupoArtistaController controller;

    @MockBean
    private RepositorioGrupoArtista repository;

    @MockBean
    private RepositorioEstabelecimento estabelecimentos;

    @MockBean
    private EmailSenderService senderService;

    @Test
    @DisplayName("Cadastro grupo de artistas")
    void cadastrar() {
        GrupoArtista grupoArtista = mock(GrupoArtista.class);

        when(repository.save(grupoArtista)).thenReturn(grupoArtista);

        assertEquals(201, controller.cadastrar(grupoArtista).getStatusCodeValue());
    }

    @Test
    @DisplayName("Exibir todos")
    void exibirTodos() {
        GrupoArtista grupoArtista = mock(GrupoArtista.class);
        GrupoArtista grupoArtista1 = mock(GrupoArtista.class);
        GrupoArtista grupoArtista2 = mock(GrupoArtista.class);

        List<GrupoArtista> lista = List.of(grupoArtista, grupoArtista1, grupoArtista2);

        when(repository.findAll()).thenReturn(lista);

        ResponseEntity<List<GrupoArtista>> resposta = controller.exibirTodos();

        assertEquals(200, resposta.getStatusCodeValue());
    }

    @Test
    @DisplayName("Exibir todos lista vazia")
    void exibirTodosListaVazia() {

        when(repository.findAll()).thenReturn(new ArrayList<>());

        ResponseEntity<List<GrupoArtista>> resposta = controller.exibirTodos();

        assertEquals(204, resposta.getStatusCodeValue());
    }

    @Test
    @DisplayName("Exibir todos vazio")
    void exibirTodosVazio() {

        List<GrupoArtista> lista = new ArrayList<>();

        when(repository.findAll()).thenReturn(lista);

        ResponseEntity<List<GrupoArtista>> resposta = controller.exibirTodos();

        assertEquals(204, resposta.getStatusCodeValue());
    }

    @Test
    @DisplayName("Testes login")
    void login() {

        GrupoArtista grupoArtista = mock(GrupoArtista.class);

        when(repository.findByEmailAndSenha("teste@gmail.com", "12345"))
                .thenReturn(grupoArtista);

        ResponseEntity resposta = controller.login("teste@gmail.com", "12345");

        assertEquals(200, resposta.getStatusCodeValue());

        assertEquals(400, controller.login("abcd","54321").getStatusCodeValue());
    }

    @Test
    @DisplayName("Testes login email nulo")
    void loginEmailNulo() {

        GrupoArtista grupoArtista = mock(GrupoArtista.class);

        when(repository.findByEmailAndSenha(null, "12345"))
                .thenReturn(grupoArtista);

        ResponseEntity resposta = controller.login(null, "12345");

        assertEquals(400, resposta.getStatusCodeValue());
    }

    @Test
    @DisplayName("Testes login senha nula")
    void loginSenhaNula() {

        GrupoArtista grupoArtista = mock(GrupoArtista.class);

        when(repository.findByEmailAndSenha("teste@gmail.com", null))
                .thenReturn(grupoArtista);

        ResponseEntity resposta = controller.login("teste@gmail.com", null);

        assertEquals(400, resposta.getStatusCodeValue());
    }

    @Test
    @DisplayName("Testes login email e senha null")
    void loginEmailESenhaNull() {

        GrupoArtista grupoArtista = mock(GrupoArtista.class);

        when(repository.findByEmailAndSenha(null, null))
                .thenReturn(grupoArtista);

        ResponseEntity resposta = controller.login(null, null);

        assertEquals(400, resposta.getStatusCodeValue());
    }

    @Test
    @DisplayName("Testes logoff")
    void logoff() {
        GrupoArtista grupoArtista = mock(GrupoArtista.class);

        when(repository.findByEmailAndSenha("teste@gmail.com", "12345"))
                .thenReturn(grupoArtista);

        ResponseEntity resposta = controller.logoff("teste@gmail.com", "12345");

        assertEquals(200, resposta.getStatusCodeValue());

        assertEquals(400, controller.logoff("abcd","54321").getStatusCodeValue());
    }

    @Test
    @DisplayName("Testes logoff email nulo")
    void logoffEmailNulo() {
        GrupoArtista grupoArtista = mock(GrupoArtista.class);

        grupoArtista.setEmail(null);
        grupoArtista.setSenha("12345");

        when(repository.save(grupoArtista)).thenReturn(grupoArtista);

        repository.save(grupoArtista);

        when(repository.findByEmailAndSenha(grupoArtista.getEmail(), grupoArtista.getSenha()))
                .thenReturn(grupoArtista);

        ResponseEntity<GrupoArtista> resposta = controller.logoff(grupoArtista.getEmail(),grupoArtista.getSenha());

        assertEquals(400, resposta.getStatusCodeValue());
    }

    @Test
    @DisplayName("Testes logoff senha nula")
    void logoffSenhaNula() {
        GrupoArtista grupoArtista = mock(GrupoArtista.class);

        grupoArtista.setEmail("teste@gmail.com");
        grupoArtista.setSenha(null);

        when(repository.save(grupoArtista)).thenReturn(grupoArtista);

        repository.save(grupoArtista);

        when(repository.findByEmailAndSenha(grupoArtista.getEmail(), grupoArtista.getSenha()))
                .thenReturn(grupoArtista);

        ResponseEntity<GrupoArtista> resposta = controller.logoff(grupoArtista.getEmail(),grupoArtista.getSenha());

        assertEquals(400, resposta.getStatusCodeValue());
    }

    @Test
    @DisplayName("Testes logoff email e senha nul")
    void logoffEmailESenhaNul() {
        GrupoArtista grupoArtista = mock(GrupoArtista.class);

        grupoArtista.setEmail(null);
        grupoArtista.setSenha(null);

        when(repository.save(grupoArtista)).thenReturn(grupoArtista);

        repository.save(grupoArtista);

        when(repository.findByEmailAndSenha(grupoArtista.getEmail(), grupoArtista.getSenha()))
                .thenReturn(grupoArtista);

        ResponseEntity<GrupoArtista> resposta = controller.logoff(grupoArtista.getEmail(),grupoArtista.getSenha());

        assertEquals(400, resposta.getStatusCodeValue());
    }
}