package com.DesafioIntegral.DesafioIntegral.prato;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PratoController {

	
	@Autowired
	private PratoService ps;
	
	@RequestMapping("/listarPratos")
	public List<Prato> getAllPratos(){
		return ps.getAllPratos();
	}
	
	@RequestMapping("/listarPratos/{id}")
	public Prato getPrato(@PathVariable String id) {
		
		return ps.getAllPratos().stream().filter(t -> t.getNome().equals(id)).findFirst().get();
		
	}
	
	@RequestMapping(value="/listarPratos", method=RequestMethod.POST)
	public void addPrato(@RequestBody Prato prato) {
		ps.addPrato(prato);
	}
	
	@RequestMapping(value="/listarPratos/{id}", method=RequestMethod.PUT)
	public void updatePrato(@RequestBody Prato prato, @PathVariable long id) {
		
		//long id = ps.getAllPratos().stream().filter(p -> p.getNome().equals(nome)).findFirst().get().getId();
		
		ps.updatePrato(prato, id);
	}
	
	@RequestMapping(value="/listarPratos/{id}", method=RequestMethod.DELETE)
	public void deletePrato(@PathVariable String id) {
		ps.deletePrato(id);
	}
	
}
