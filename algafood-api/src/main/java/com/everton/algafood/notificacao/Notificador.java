package com.everton.algafood.notificacao;


import com.everton.algafood.model.Cliente;

public interface Notificador {

	void notificar(Cliente cliente, String mensagem);

}