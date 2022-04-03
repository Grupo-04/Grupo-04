package sptech.unlock.loginusuario.interfaces;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

public interface Registravel<E,V> {

//    @PostMapping
    public E cadastrar(@RequestBody V usuario);

//    @PutMapping
//    public E atualizar(@RequestBody V usuario);
//
//    @DeleteMapping
//    public ResponseEntity excluir(@PathVariable String email, @PathVariable String senha);
//
//    @GetMapping
    public E exibirTodos();
}
