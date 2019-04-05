package com.DesafioIntegral.DesafioIntegral.prato;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public Optional<Prato> getPrato(String id) {
		// return pratos.stream().filter(p -> p.getNome().equals(id)).findFirst().get();
		
		return pr.findById(id);
	}
	
	public void addPrato(Prato prato) {
		
		pr.save(prato); // Adiciona um prato no banco de dados.
		
	}
	
	public void updatePrato(Prato prato, long id) {
		
		pr.save(prato);
		
	}

	public void deletePrato(String id) {
		
		pr.deleteById(id);
		
	}
	
}
