package com.tempo.services;


import java.util.Optional;

import com.tempo.entities.Cidade;
import com.tempo.entities.Root;


public interface CidadeService {

	Optional<Cidade> buscarPorNome(String nome);
	
	Cidade persistir(Cidade cidade);
		
	Optional<Root> getClima(String cidade);
}
