package br.com.murilo.listavip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.murilo.listavip.entity.Convidado;
import br.com.murilo.listavip.service.ConvidadoService;

@Controller
public class ConvidadoController {

	@Autowired
	private ConvidadoService service;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("listaconvidados")
	public String listaConvidados(Model model) {
		model.addAttribute("convidados", service.findAll());
		return "listaconvidados";
	}

	@PostMapping(value = "salvar")
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email,
			@RequestParam("telefone") String telefone, Model model) {
		
		service.save(new Convidado(nome, email, telefone));
		model.addAttribute("convidados", service.findAll());
		return "listaconvidados";
	}
}
