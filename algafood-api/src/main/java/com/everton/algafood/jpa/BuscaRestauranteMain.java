package com.everton.algafood.jpa;

import com.everton.algafood.AlgafoodApiApplication;
import com.everton.algafood.domain.model.Restaurante;
import com.everton.algafood.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class BuscaRestauranteMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
        Restaurante restaurante = restauranteRepository.buscar(1L);

        System.out.println(restaurante.getNome());
    }

}
