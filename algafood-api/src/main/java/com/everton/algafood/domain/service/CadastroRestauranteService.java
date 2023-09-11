package com.everton.algafood.domain.service;

import com.everton.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.everton.algafood.domain.model.Restaurante;
import com.everton.algafood.domain.repository.CozinhaRepository;
import com.everton.algafood.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroRestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Restaurante salvar(Restaurante restaurante) {
        Long cozinhaId = restaurante.getCozinha().getId();
        var cozinha = cozinhaRepository.findById(cozinhaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format("Não existe cadastro de cozinha com o código %d", cozinhaId)
                ));
        restaurante.setCozinha(cozinha);
        return restauranteRepository.save(restaurante);
    }
}
