package com.everton.algafood.jpa;

import com.everton.algafood.AlgafoodApiApplication;
import com.everton.algafood.domain.model.Restaurante;
import com.everton.algafood.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

public class AlteracaoRestauranteMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);

        Restaurante restaurante = new Restaurante();
        restaurante.setId(2L);
        restaurante.setNome("Italiano Restaurante");
        restaurante.setTaxaFrete(BigDecimal.valueOf(18.00));

        restaurante = restauranteRepository.salvar(restaurante);

        System.out.printf("%d - %s\n", restaurante.getId(), restaurante.getNome());
    }

}
