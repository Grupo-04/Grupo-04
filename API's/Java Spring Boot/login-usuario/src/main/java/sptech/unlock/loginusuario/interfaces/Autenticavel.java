package sptech.unlock.loginusuario.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface Autenticavel {

    public ResponseEntity login(@RequestParam String email, @RequestParam String senha);

    public ResponseEntity logoff(@RequestParam String email, @RequestParam String senha);
}
