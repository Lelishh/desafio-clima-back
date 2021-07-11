package com.tempo.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tempo.entities.Cidade;
import com.tempo.entities.Root;
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

	
	@Override
	public Optional<Root> getClima(String cidade) {
		RestTemplate rest = new RestTemplate();
		Root root = rest.getForObject("https://api.hgbrasil.com/weather?key=7721ecf0&city_name="+cidade, Root.class);
		return Optional.ofNullable(root);
	}
}