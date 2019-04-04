package com.DesafioIntegral.DesafioIntegral.prato;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class getPratos {

	@RequestMapping("/getPratos")
	public List<Prato> getAllPratos(){
		return Arrays.asList(
				new Prato("Camarão", "Prato feito com camarões", 10),
				new Prato("Feijão", "Prato de arroz com feijão", 7)
				);
	}
	
}
