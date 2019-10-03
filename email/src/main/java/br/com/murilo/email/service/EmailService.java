package br.com.murilo.email.service;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	public void enviar(String nome, String destinatario) {
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("murilofelpetocursos", "xtwvcfbzpogkuefw"));
			email.setSSLOnConnect(true);
			email.setFrom("murilofelpetocursos@gmail.com");
			email.setSubject("Você foi convidado pelo Lista Vip");
			email.setMsg("Olá " + nome + "! \n Você foi acaba de ser convidado pelo ListaVIP.");
			email.addTo(destinatario);
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
}
