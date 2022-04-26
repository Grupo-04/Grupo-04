package sptech.unlock.loginusuario.observer;

import org.springframework.beans.factory.annotation.Autowired;
import sptech.unlock.loginusuario.email.service.EmailSenderService;

public class StringObserver extends Observer {

    @Autowired
    private EmailSenderService senderService;

    public StringObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("String value: " + Integer.toString(subject.getState()));
    }

}
