package com.tempo.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tempo.entities.Cidade;
import com.tempo.response.Response;
import com.tempo.services.CidadeService;



@RestController
@RequestMapping("/api/cidade")
@CrossOrigin(origins = "*")
public class CidadeController {

	
	@Autowired
	private CidadeService cidadeService;
	
	public CidadeController() {
	}

	@PostMapping
	public ResponseEntity<Response<Cidade>> cadastrar(@RequestBody Cidade cidadeParam, BindingResult result) throws NoSuchAlgorithmException {
		
		Response<Cidade> response = new Response<Cidade>();
				
		if (result.hasErrors()) {			
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		Optional<Cidade> cidade = this.cidadeService.buscarPorNome(cidadeParam.getNome());
		if (cidade.isPresent()) {
			result.addError(new ObjectError("cidade", "Cidade já cadastrada."));
			response.getErrors().add(new ObjectError("cidade", "Cidade já cadastrada.").toString());
			return ResponseEntity.badRequest().body(response);
		}
		
		
		Cidade cidadeRetorno = cidade.get();
		this.cidadeService.persistir(cidadeRetorno);
		
		response.setData(cidadeRetorno);
		return ResponseEntity.ok(response);
	}

	
	@GetMapping(value = "/")
	public ResponseEntity<Response<String>> teste() {
		return ResponseEntity.ok(new Response<String>());
	}
	
	
	@GetMapping(value = "/cidades/{nome}")
	public ResponseEntity<Response<Cidade>> listarPorCidadeId(@PathVariable("nome") String nome) {
		
		Response<Cidade> response = new Response<Cidade>();
		Optional<Cidade> cidade = this.cidadeService.buscarPorNome(nome);
		if (! cidade.isPresent()) {
			response.getErrors().add(new ObjectError("cidade", "Cidade não cadastrada.").toString());
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(cidade.get());
		return ResponseEntity.ok(response);
	}
	
	


}