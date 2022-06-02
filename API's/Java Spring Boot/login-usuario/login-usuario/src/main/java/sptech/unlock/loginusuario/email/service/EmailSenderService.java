package sptech.unlock.loginusuario.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    private String erro;

    public String getErro() {
        return erro;
    }

    public void sendEmail(
            String destinatario,
            String titulo,
            String texto
            )
    {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("talktounlock@gmail.com");
        message.setTo(destinatario);
        message.setSubject(titulo);
        message.setText(texto);

        mailSender.send(message);

    }

    public boolean validarEmail(String destinatario) {

        try {
            InternetAddress emailAddr = new InternetAddress(destinatario);
            emailAddr.validate();
            return true;
        } catch (
                AddressException e) {
            erro += e.toString();
            return false;
        }

    }

}
