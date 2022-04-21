package sptech.unlock.loginusuario.email.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sptech.unlock.loginusuario.email.model.Email;
import sptech.unlock.loginusuario.email.service.EmailSenderService;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailSenderService senderService;

    @PostMapping
    public ResponseEntity<Object> sendMail(
            @RequestBody Email email
    ) {

        boolean emailValido = true;
        String erro = "";
        try {
            InternetAddress emailAddr = new InternetAddress(email.getDestinatario());
            emailAddr.validate();
        } catch (AddressException e) {
            erro += e.toString();
            emailValido = false;
        }

        if (emailValido) {
            senderService.sendEmail(
                    email.getDestinatario(),
                    email.getTitulo(),
                    email.getTexto()
            );
            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).body(erro);

    }
}
