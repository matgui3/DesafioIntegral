package com.DesafioIntegral.DesafioIntegral.prato;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;

@Service
public class PratoService {

	@Autowired
	private PratoRepository pr;
	
	private ArrayList<Prato> pratos = new ArrayList<>();
	
	public List<Prato> getAllPratos(){
		
		//Retorna todos os pratos
		
		List<Prato> pratos = new ArrayList<>();
		pr.findAll().forEach(pratos::add);
		
		return pratos;
		
	}
	
	public Optional<Prato> getPrato(Long id) {
		// return pratos.stream().filter(p -> p.getNome().equals(id)).findFirst().get();
		
		return pr.findById(id);
	}
	
	public Prato addPrato(Prato prato) {
		
		return pr.save(prato); // Adiciona um prato no banco de dados e retorna o objeto que foi adicionado.
		
	}
	
	public Prato updatePrato(Prato prato, Long id) {		
		Prato p = pr.findById(id).get();
		p = prato;
		p.setId(id);
		return pr.save(p); // Retorna o elemento que foi salvo.
	}

	public boolean deletePrato(Long id) {
		
		boolean prato_existe = pr.existsById(id);
		
		if(prato_existe) {
			pr.deleteById(id);
			return true;
		} else {
			return false;
		}		
		
	}
	
}
