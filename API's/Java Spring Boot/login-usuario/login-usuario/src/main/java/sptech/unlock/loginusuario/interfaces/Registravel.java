package sptech.unlock.loginusuario.interfaces;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

public interface Registravel<E,V> {

    public E cadastrar(@RequestBody V usuario);

    public E exibirTodos();
}
