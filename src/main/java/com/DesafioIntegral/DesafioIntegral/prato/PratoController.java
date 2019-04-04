package com.DesafioIntegral.DesafioIntegral.prato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.DesafioIntegral.DesafioIntegral.repositories.PratoRepository;

@RestController
public class PratoController {

		
	@Autowired
	private PratoRepository pr;
	
	/**
	 * Atende a requisição para cadastrar um novo prato.
	 * @return Retorna o formulário de cadastro de prato.
	 */
	@RequestMapping(value="/cadastrarPrato", method = RequestMethod.GET)
	public String form() {
		return "restaurante/formPrato";
	}
	
	/**
	 * Recebe os dados do formulário preenchido para o cadastro de prato e salva no repositório de pratos.
	 * @param prato Dados a serem inseridos no novo prato cadastrado.
	 * @return Redireciona o usuário para o cadastro de pratos.
	 */
	@RequestMapping(value="/cadastrarPrato", method = RequestMethod.POST)
	public String form(Prato prato) {
		
		pr.save(prato);
		
		return "redirect:/cadastrarPrato";
		
	}
	
}
