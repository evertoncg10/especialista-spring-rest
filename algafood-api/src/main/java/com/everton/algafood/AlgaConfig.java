package com.everton.algafood;

import com.everton.algafood.notificacao.NotificadorEmail;
import com.everton.algafood.service.AtivacaoClienteService;
import org.springframework.context.annotation.Bean;

//@Configuration
public class AlgaConfig {

	@Bean
	public NotificadorEmail notificadorEmail() {
		NotificadorEmail notificador = new NotificadorEmail("smtp.algamail.com.br");
		notificador.setCaixaAlta(true);
		
		return notificador;
	}
	
	@Bean
	public AtivacaoClienteService ativacaoClienteService() {
		return new AtivacaoClienteService(notificadorEmail());
	}
	
}
