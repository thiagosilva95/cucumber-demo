package com.tdev.steps;

import java.time.LocalDate;

import org.junit.Assert;

import com.tdev.entity.Filme;
import com.tdev.entity.NotaAluguel;
import com.tdev.service.AluguelService;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class AlugarFilmeSteps {
	
	private Filme filme;
	private AluguelService aluguelService = new AluguelService();
	private NotaAluguel notaAluguel;
	private String erro;
	private String tipoAluguel;

	@Dado("um filme com estoque de {int} unidades")
	public void umFilmeComEstoqueDeUnidades(Integer estoque) {
	    filme = new Filme();
	    filme.setEstoque(estoque);
	}

	@Dado("que o preço do aluguel seja R$ {int}")
	public void queOPreçoDoAluguelSejaR$(Integer aluguel) {
	    filme.setAluguel(aluguel);
	}

	@Quando("alugar")
	public void alugar() {
		try {
			notaAluguel = aluguelService.alugar(filme, tipoAluguel);
		} catch (RuntimeException e) {
			erro = e.getMessage();
		}
	}

	@Então("o preço do aluguel será R$ {int}")
	public void oPreçoDoAluguelSeráR$(Integer int1) {
	    Assert.assertEquals(int1, notaAluguel.getPreco());
	}

	@Então("o estoque do filme será {int} unidade")
	public void oEstoqueDoFilmeSeráUnidade(Integer int1) {
	    Assert.assertEquals(int1, filme.getEstoque());
	}
	
	@Então("não será possível por falta de estoque")
	public void nãoSeráPossívelPorFaltaDeEstoque() {
		Assert.assertEquals("Filme sem estoque", erro);
	}
	
	@Dado("que o tipo do aluguel seja (.*)")
	public void queOTipoDoAluguelSejaExtendido(String categoria) {
		tipoAluguel = categoria;
	}

	@Então("a data de entrega será em (\\d+) dias?$")
	public void aDataDeEntregaSeráEmDias(Integer int1) {
		LocalDate dataEsperada = LocalDate.now().plusDays(int1);
		
		LocalDate dataEntrega = notaAluguel.getDataEntrega();
	    
	    Assert.assertEquals(dataEsperada, dataEntrega);
	}

	@Então("a pontuação recebida será de {int} pontos")
	public void aPontuaçãoRecebidaSeráDePontos(Integer pontuacao) {
		Assert.assertEquals(pontuacao, notaAluguel.getPontuacao());
	}
}
