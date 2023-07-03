package com.everton.algafood.service;

import com.everton.algafood.model.Cliente;
import com.everton.algafood.notificacao.NivelUrgencia;
import com.everton.algafood.notificacao.Notificador;
import com.everton.algafood.notificacao.TipoDoNotificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

	@TipoDoNotificador(NivelUrgencia.URGENTE)
	@Autowired
	private Notificador notificador;

	public void ativar(Cliente cliente) {
		cliente.ativar();

		notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
	}
}
