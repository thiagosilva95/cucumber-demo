package com.tdev.service;

import java.time.LocalDate;

import com.tdev.entity.Filme;
import com.tdev.entity.NotaAluguel;
import com.tdev.entity.TipoAluguel;

public class AluguelService {
	
	public NotaAluguel alugar(Filme filme, TipoAluguel tipoAluguel) {
		if (filme.getEstoque() == 0) {
			throw new RuntimeException("Filme sem estoque");
		}
		
		NotaAluguel nota = new NotaAluguel();
		
		switch (tipoAluguel) {
		case COMUN:
			nota.setPreco(filme.getAluguel());
			nota.setDataEntrega(LocalDate.now().plusDays(1));
			nota.setPontuacao(1);
			break;
		case EXTENDIDO:
			nota.setPreco(filme.getAluguel() * 2);
			nota.setDataEntrega(LocalDate.now().plusDays(3));
			nota.setPontuacao(2);
			break;
		case SEMANAL:
			nota.setPreco(filme.getAluguel() * 3);
			nota.setDataEntrega(LocalDate.now().plusDays(7));
			nota.setPontuacao(3);
			break;
		}	
		
		filme.setEstoque(filme.getEstoque() - 1);
		return nota;
	}

}
