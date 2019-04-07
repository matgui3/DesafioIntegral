package com.DesafioIntegral.DesafioIntegral.cozinheiro;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.DesafioIntegral.DesafioIntegral.prato.Prato;

public interface CozinheiroRepository extends CrudRepository<Cozinheiro, Long>{
	
	
}
