package com.tdev.steps;

import java.time.LocalDate;
import java.util.Map;

import org.junit.Assert;

import com.tdev.entity.Filme;
import com.tdev.entity.NotaAluguel;
import com.tdev.entity.TipoAluguel;
import com.tdev.service.AluguelService;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.cucumber.datatable.DataTable;

public class AlugarFilmeSteps {
	
	private Filme filme;
	private AluguelService aluguelService = new AluguelService();
	private NotaAluguel notaAluguel;
	private String erro;
	private TipoAluguel tipoAluguel = TipoAluguel.COMUN;

	@Dado("um filme com estoque de {int} unidades")
	public void umFilmeComEstoqueDeUnidades(Integer estoque) {
	    filme = new Filme();
	    filme.setEstoque(estoque);
	}

	@Dado("que o preço do aluguel seja R$ {int}")
	public void queOPrecoDoAluguelSeja(Integer aluguel) {
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

	@Entao("o preço do aluguel será R$ {int}")
	public void oPrecoDoAluguelSera(Integer int1) {
	    Assert.assertEquals(int1, notaAluguel.getPreco());
	}

	@Entao("o estoque do filme será {int} unidade")
	public void oEstoqueDoFilmeSeraUnidade(Integer int1) {
	    Assert.assertEquals(int1, filme.getEstoque());
	}
	
	@Entao("não será possível por falta de estoque")
	public void naoSeraPossivelPorFaltaDeEstoque() {
		Assert.assertEquals("Filme sem estoque", erro);
	}
	
	@Dado("que o tipo do aluguel seja (.*)")
	public void queOTipoDoAluguelSejaExtendido(String tipo) {
		tipoAluguel = tipo.equals("semanal") ? TipoAluguel.SEMANAL : tipo.equals("extendido") ? TipoAluguel.EXTENDIDO : TipoAluguel.COMUN;
	}

	@Entao("a data de entrega será em (\\d+) dias?$")
	public void aDataDeEntregaSeraEmDias(Integer int1) {
		LocalDate dataEsperada = LocalDate.now().plusDays(int1);
		
		LocalDate dataEntrega = notaAluguel.getDataEntrega();
	    
	    Assert.assertEquals(dataEsperada, dataEntrega);
	}

	@Entao("a pontuação recebida será de {int} pontos")
	public void aPontuacaoRecebidaSeraDePontos(Integer pontuacao) {
		Assert.assertEquals(pontuacao, notaAluguel.getPontuacao());
	}
	
	@Dado("um filme")
	public void umFilme(DataTable table) {
	    Map<String, String> map = table.asMap(String.class, String.class);
	    filme = new Filme();
	    filme.setEstoque(Integer.parseInt(map.get("estoque")));
	    filme.setAluguel(Integer.parseInt(map.get("preco")));
	}
}
