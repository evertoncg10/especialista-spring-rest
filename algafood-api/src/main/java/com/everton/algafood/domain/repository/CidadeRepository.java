package com.everton.algafood.domain.repository;

import com.everton.algafood.domain.model.Cidade;

import java.util.List;

public interface CidadeRepository {

	List<Cidade> listar();
	Cidade buscar(Long id);
	Cidade salvar(Cidade cidade);
	void remover(Long cidadeId) throws IllegalArgumentException;
	
}
