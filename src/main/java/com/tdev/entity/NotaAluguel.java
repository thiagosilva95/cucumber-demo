package com.tdev.entity;

import java.time.LocalDate;

public class NotaAluguel {

	private Integer preco;
	private LocalDate dataEntrega;
	private Integer pontuacao;

	public Integer getPreco() {
		return preco;
	}

	public void setPreco(Integer preco) {
		this.preco = preco;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	
	public LocalDate getDataEntrega() {
		return this.dataEntrega;
	}

	public Integer getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
	}
	
}
