package com.DesafioIntegral.DesafioIntegral.prato;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;

@RestController
public class PratoController {

	@Autowired
	private PratoService ps;

	@RequestMapping("/Pratos")
	public List<Prato> getAllPratos() {
		return ps.getAllPratos();
	}

	@RequestMapping("/Pratos/{id}")
	public Optional<Prato> getPrato(@PathVariable Long id) {
		return ps.getPrato(id);
	}

	@RequestMapping(value = "/Pratos", method = RequestMethod.POST)
	public Prato addPrato(@RequestBody Prato prato) {
		return ps.addPrato(prato);
	}

	@RequestMapping(value = "/Pratos/{id}", method = RequestMethod.PUT)
	public Prato updatePrato(@RequestBody Prato prato, @PathVariable Long id) {
		return ps.updatePrato(prato, id);

	}

	@RequestMapping(value = "/Pratos/{id}", method = RequestMethod.DELETE)
	public String deletePrato(@PathVariable Long id) {
		if(ps.deletePrato(id)) {
			return "Prato deletado com sucesso!";
		} else {
			return "Índice de prato não encontrado.";
		}
	}

}
