package com.tempo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tempo.entities.Cidade;

@Transactional(readOnly = true)
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	@Transactional(readOnly = true)
	Cidade findByNome(String nome);
}