package com.everton.algafood.api.controller;

import com.everton.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.everton.algafood.domain.model.Restaurante;
import com.everton.algafood.domain.repository.RestauranteRepository;
import com.everton.algafood.domain.service.CadastroRestauranteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes") //, produces = MediaType.APPLICATION_JSON_VALUE
public class RestauranteController {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CadastroRestauranteService cadastroRestaurante;

    @GetMapping
    public List<Restaurante> listar() {
        return restauranteRepository.listar();
    }

    @GetMapping("/{restauranteId}")
    public ResponseEntity<Restaurante> buscar(@PathVariable Long restauranteId) {
        var restaurante = restauranteRepository.buscar(restauranteId);
        if (restaurante != null) {
            return ResponseEntity.ok(restaurante);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody Restaurante restaurante) {
        try {
            Restaurante restauranteSalvo = cadastroRestaurante.salvar(restaurante);
            return ResponseEntity.status(HttpStatus.CREATED).body(restauranteSalvo);

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{restauranteId}")
    public ResponseEntity<?> atualizar(@PathVariable Long restauranteId, @RequestBody Restaurante restaurante) {
        try {
            Restaurante restauranteAtual = restauranteRepository.buscar(restauranteId);
            if (restauranteAtual != null) {
                BeanUtils.copyProperties(restaurante, restauranteAtual, "id");
                Restaurante restauranteEditado = cadastroRestaurante.salvar(restauranteAtual);
                return ResponseEntity.ok(restauranteEditado);
            }
            return ResponseEntity.notFound().build();
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
