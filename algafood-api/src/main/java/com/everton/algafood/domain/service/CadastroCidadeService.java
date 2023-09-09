package com.everton.algafood.domain.service;

import com.everton.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.everton.algafood.domain.model.Cidade;
import com.everton.algafood.domain.model.Estado;
import com.everton.algafood.domain.repository.CidadeRepository;
import com.everton.algafood.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroCidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public Cidade salvar(Cidade cidade) {
        Long estadoId = cidade.getEstado().getId();
        Estado estado = estadoRepository.buscar(estadoId);

        if (estado == null) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe cadastro de Estado com o código %d", estadoId)
            );
        }
        cidade.setEstado(estado);
        return cidadeRepository.salvar(cidade);
    }

    public Cidade buscar(Long cidadeId) {
        Cidade cidade = cidadeRepository.buscar(cidadeId);
        if (cidade == null) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe um cadastro de cidade com o código %d", cidadeId)
            );
        }
        return cidade;
    }

    public void excluir(Long cidadeId) {
        try {
            cidadeRepository.remover(cidadeId);

        } catch (IllegalArgumentException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe um cadastro de cidade com o código %d", cidadeId)
            );
        }
    }
}
