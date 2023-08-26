package com.everton.algafood.jpa;

import com.everton.algafood.AlgafoodApiApplication;
import com.everton.algafood.domain.model.Restaurante;
import com.everton.algafood.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

public class InclusaoRestauranteMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);

        Restaurante restaurante1 = new Restaurante();
        restaurante1.setNome("Jan Pieter");
        restaurante1.setTaxaFrete(BigDecimal.valueOf(12.00));

        Restaurante restaurante2 = new Restaurante();
        restaurante2.setNome("Do Vale");
        restaurante2.setTaxaFrete(BigDecimal.valueOf(30.00));

        restaurante1 = restauranteRepository.salvar(restaurante1);
        restaurante2 = restauranteRepository.salvar(restaurante2);

        System.out.printf("%d - %s\n", restaurante1.getId(), restaurante1.getNome());
        System.out.printf("%d - %s\n", restaurante2.getId(), restaurante2.getNome());
    }

}
