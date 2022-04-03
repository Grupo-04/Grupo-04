package sptech.unlock.loginusuario.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface Autenticavel {

    @PostMapping("/login")
    public ResponseEntity login(@PathVariable String email, @PathVariable String senha);

    @DeleteMapping("/logoff")
    public ResponseEntity logoff(@PathVariable String email, @PathVariable String senha);
}
