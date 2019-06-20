package com.tdev.service;

import java.time.LocalDate;

import com.tdev.entity.Filme;
import com.tdev.entity.NotaAluguel;

public class AluguelService {
	
	public NotaAluguel alugar(Filme filme, String tipoAluguel) {
		if (filme.getEstoque() == 0) {
			throw new RuntimeException("Filme sem estoque");
		}
		
		NotaAluguel nota = new NotaAluguel();
		
		if ("extendido".equals(tipoAluguel)) {
			nota.setPreco(filme.getAluguel() * 2);
			nota.setDataEntrega(LocalDate.now().plusDays(3));
			nota.setPontuacao(2);
		} else {
			nota.setPreco(filme.getAluguel());
			nota.setDataEntrega(LocalDate.now().plusDays(1));
			nota.setPontuacao(1);
		}		
		
		filme.setEstoque(filme.getEstoque() - 1);
		return nota;
	}

}
