package br.com.murilo.listavip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.murilo.email.service.EmailService;
import br.com.murilo.listavip.entity.Convidado;
import br.com.murilo.listavip.repository.ConvidadoRepository;

@Service
public class ConvidadoService {

	@Autowired
	private ConvidadoRepository repository;
	
	public List<Convidado> findAll(){
		return repository.findAll();
	}
	
	public void save(Convidado convidado) {
		repository.save(convidado);
		this.enviarEmail(convidado.getNome(), convidado.getEmail());
	}
	
	private void enviarEmail(String nome, String email) {
		EmailService emailService = new EmailService();		
		emailService.enviar(nome, email);
	}
}
