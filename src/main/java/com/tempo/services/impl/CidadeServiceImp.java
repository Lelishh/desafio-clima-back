package com.tempo.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tempo.entities.Cidade;
import com.tempo.repositories.CidadeRepository;
import com.tempo.services.CidadeService;



@Service
public class CidadeServiceImp implements CidadeService {


	@Autowired
	private CidadeRepository cidadeRepository;

	@Override
	public Optional<Cidade> buscarPorNome(String nome) {
		return Optional.ofNullable(cidadeRepository.findByNome(nome));
	}

	@Override
	public Cidade persistir(Cidade cidade) {
		return this.cidadeRepository.save(cidade);
	}

}