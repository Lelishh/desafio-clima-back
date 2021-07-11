package com.tempo.services;


import java.util.Optional;

import com.tempo.entities.Cidade;


public interface CidadeService {

	Optional<Cidade> buscarPorNome(String nome);
	
	Cidade persistir(Cidade cidade);
	
}
