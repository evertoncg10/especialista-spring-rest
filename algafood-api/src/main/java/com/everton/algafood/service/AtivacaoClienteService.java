package com.everton.algafood.service;

import com.everton.algafood.model.Cliente;
import com.everton.algafood.notificacao.NivelUrgencia;
import com.everton.algafood.notificacao.Notificador;
import com.everton.algafood.notificacao.TipoDoNotificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class AtivacaoClienteService {

	@TipoDoNotificador(NivelUrgencia.NAO_URGENTE)
	@Autowired
	private Notificador notificador;

	@PostConstruct
	public void init() {
		System.out.println("INIT");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("DESTROY");
	}

	public void ativar(Cliente cliente) {
		cliente.ativar();

		notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
	}
}
