package com.DesafioIntegral.DesafioIntegral.cozinheiro;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DesafioIntegral.DesafioIntegral.prato.Prato;
import com.DesafioIntegral.DesafioIntegral.prato.PratoRepository;

@Service
public class CozinheiroService {

	@Autowired
	private CozinheiroRepository cr;
	
	@Autowired
	private PratoRepository pr;

	public List<Cozinheiro> getAllCozinheiros() {
		List<Cozinheiro> cozinheiros = new ArrayList<>();

		cr.findAll().forEach(cozinheiros::add);
		return cozinheiros;
	}

	public Cozinheiro getCozinheiro(Long id) {
		
		if(cr.existsById(id)) {
			return cr.findById(id).get(); // Retorna o cozinheiro com o id informado no parâmetro.
		} else {
			return null;
		}
		
	}

	public Cozinheiro addCozinheiro(Cozinheiro cozinheiro) {
		return cr.save(cozinheiro);
	}

	public Cozinheiro updateCozinheiro(Cozinheiro cozinheiro, Long id) {

		Cozinheiro c;
		
		if(cr.existsById(id)) {
			c = cr.findById(id).get();
			c = cozinheiro;
			c.setId_cozinheiro(id);
			cr.save(c); // Retorna o elemento que foi salvo.
		} else {
			c = null;
		}
		
		return c;

	}

	public boolean deleteCozinheiro(Long id) {

		boolean coz_existe = cr.existsById(id);

		if (coz_existe) {
			Cozinheiro c = cr.findById(id).get();
			c.removeAllEspecialidades();
			cr.save(c);
			cr.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
	
	public Cozinheiro addEspecialidade(Long id_cozinheiro, Long id_prato) {
		
		if(cr.existsById(id_cozinheiro) && pr.existsById(id_prato)) {
			Cozinheiro c = cr.findById(id_cozinheiro).get();
			Prato p = pr.findById(id_prato).get();
			c.addEspecialidade(p);
			return cr.save(c);
		} else {
			return null;
		}
	}

	public List<Prato> getEspecialidades(Long id) {
		
		List<Prato> especialidades = cr.findById(id).get().getEspecialidades();
		
		return especialidades;
	}

}
