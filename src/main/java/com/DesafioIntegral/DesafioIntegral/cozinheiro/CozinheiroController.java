package com.DesafioIntegral.DesafioIntegral.cozinheiro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.DesafioIntegral.DesafioIntegral.prato.Prato;

@RestController
public class CozinheiroController {
	
	@Autowired
	private CozinheiroService cozService;
	
	@RequestMapping("/Cozinheiros")
	public java.util.List<Cozinheiro> Cozinheiros(){
		return cozService.getAllCozinheiros();
	}
	
	@RequestMapping("/Cozinheiros/{id}")
	public Object getCozinheiro(@PathVariable Long id) {
		
		Cozinheiro c = cozService.getCozinheiro(id);
		
		if(c==null) {
			return "Falha ao encontrar o cozinheiro de índice " + id;
		} else {
			return c;
		}
		
	}
	
	@RequestMapping(value = "/Cozinheiros", method = RequestMethod.POST)
	public Cozinheiro addCozinheiro(@RequestBody Cozinheiro cozinheiro) {
		return cozService.addCozinheiro(cozinheiro);
	}
	
	@RequestMapping(value = "/Cozinheiros/{id}", method = RequestMethod.PUT)
	public Object updateCozinheiro(@RequestBody Cozinheiro cozinheiro, @PathVariable Long id) {

		Cozinheiro c = cozService.updateCozinheiro(cozinheiro, id);
		
		if(c == null) {
			return "Falha ao encontrar o cozinheiro de índice " + id;
		} else {
			return c;
		}
	}
	
	@RequestMapping(value = "/Cozinheiros/{id}", method = RequestMethod.DELETE)
	public String deleteCozinheiro(@PathVariable Long id) {
		
		if(cozService.deleteCozinheiro(id)) {
			return "Cozinheiro deletado com sucesso!";
		} else {
			return "Falha ao encontrar o cozinheiro de índice " + id;
		}
	}
	
	@RequestMapping(value = "/Cozinheiros/addEspecialidade/{id_cozinheiro}/{id_prato}", method = RequestMethod.POST)
	public Object addEspecialidade(@PathVariable long id_cozinheiro, @PathVariable long id_prato){
		
		Cozinheiro c = cozService.addEspecialidade(id_cozinheiro, id_prato);
		
		if(c != null) {
			return c;
		} else {
			return "Prato ou Cozinheiro não encontrados. Confira os IDs e tente novamente.";
		}
		
	}
	
	@RequestMapping(value = "/Cozinheiros/{id}/Pratos")
	public List<Prato> getEspecialidades(@PathVariable Long id){
		return cozService.getEspecialidades(id);
	}
	
}
