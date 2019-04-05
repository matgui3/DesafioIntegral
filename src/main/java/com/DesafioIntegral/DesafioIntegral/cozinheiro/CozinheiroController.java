package com.DesafioIntegral.DesafioIntegral.cozinheiro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class listarCozinheiros {
	
	@Autowired
	private CozinheiroService cozService;
	
	@RequestMapping("/listarCozinheiros")
	public java.util.List<Cozinheiro> listarCozinheiros(){
		return cozService.getAllCozinheiros();
	}
	
	@RequestMapping("/listarCozinheiros/{id}")
	public Cozinheiro getCozinheiro(@PathVariable String id) {
		
		return cozService.getCozinheiro(id);
		
	}
	
	@RequestMapping(value = "/listarCozinheiros", method = RequestMethod.POST)
	public void addCozinheiro(@RequestBody Cozinheiro cozinheiro) {
		cozService.addCozinheiro(cozinheiro);
	}
	
	@RequestMapping(value = "/listarCozinheiros/{id}", method = RequestMethod.PUT)
	public void updateCozinheiro(@RequestBody Cozinheiro cozinheiro, @PathVariable String id) {
		cozService.updateCozinheiro(cozinheiro, id);
	}
	
	@RequestMapping(value = "/listarCozinheiros/{id}", method = RequestMethod.DELETE)
	public void deleteCozinheiro(@PathVariable String id) {
		cozService.deleteCozinheiro(id);
	}
	
}
