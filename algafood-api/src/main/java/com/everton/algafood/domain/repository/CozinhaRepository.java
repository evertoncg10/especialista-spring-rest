package com.everton.algafood.domain.repository;

import com.everton.algafood.domain.model.Cozinha;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CozinhaRepository extends CustomJpaRepository<Cozinha, Long> {
    List<Cozinha> findCozinhasByNomeContaining(String nome);
    Optional<Cozinha> findByNome(String nome);
    boolean existsByNome(String nome);
}
