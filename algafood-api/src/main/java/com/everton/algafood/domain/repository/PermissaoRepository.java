package com.everton.algafood.domain.repository;

import com.everton.algafood.domain.model.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissaoRepository extends JpaRepository<FormaPagamento, Long> {
}
