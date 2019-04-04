package com.DesafioIntegral.DesafioIntegral.prato;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PratoService {

	private ArrayList<Prato> pratos = new ArrayList<>(Arrays.asList(
			new Prato("Feijão", "Prato contendo arroz e feijão", 8),
			new Prato("Feijoada", "Panela de feijão com grande variedade de carnes", 10),
			new Prato("Camarão", "Prato com frutor do mar", 15)
		));
	
	public List<Prato> getAllPratos(){
		
		return pratos;
		
	}
	
	public void addPrato(Prato prato) {
		pratos.add(prato);
	}
	
}
