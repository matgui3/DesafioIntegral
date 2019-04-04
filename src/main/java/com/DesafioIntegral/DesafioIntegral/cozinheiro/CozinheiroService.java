package com.DesafioIntegral.DesafioIntegral.cozinheiro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.DesafioIntegral.DesafioIntegral.prato.Prato;

@Service
public class CozinheiroService {
	
	private List<Cozinheiro> cozinheiros = new ArrayList<>(Arrays.asList(
			
				new Cozinheiro("Rodrigo", new ArrayList<Prato>()),
				new Cozinheiro("Tomio", new ArrayList<Prato>()),
				new Cozinheiro("Beto", new ArrayList<Prato>())
			
			));
	
	public List<Cozinheiro> getAllCozinheiros(){
		return cozinheiros;
	}
	
	public Cozinheiro getCozinheiro(String id) {
		return cozinheiros.stream().filter(t -> t.getNome().equals(id)).findFirst().get();
	}
	
	public void addCozinheiro(Cozinheiro cozinheiro) {
		cozinheiros.add(cozinheiro);
	}
	
}
