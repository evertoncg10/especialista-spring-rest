package com.everton.algafood.jpa;

import com.everton.algafood.AlgafoodApiApplication;
import com.everton.algafood.domain.model.FormaPagamento;
import com.everton.algafood.domain.repository.FormaPagamentoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaFormaPagamentoMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		FormaPagamentoRepository formaPagamentoRepository = applicationContext.getBean(FormaPagamentoRepository.class);
		
		List<FormaPagamento> todasFormasPagamentos = formaPagamentoRepository.listar();

		todasFormasPagamentos.forEach(formaPagamento -> System.out.println(formaPagamento.getDescricao()));
	}
	
}
