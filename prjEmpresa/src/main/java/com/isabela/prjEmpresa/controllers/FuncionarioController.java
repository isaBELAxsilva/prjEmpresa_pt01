package com.isabela.prjEmpresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isabela.prjEmpresa.entities.Funcionario;
import com.isabela.prjEmpresa.services.FuncionarioService;



@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	private final FuncionarioService service;

	@GetMapping("/home")
	public String paginaInicial() {
		return "index";
	}

	@Autowired
	public FuncionarioController(FuncionarioService service) {
		this.service = service;
	}

	@PostMapping
	public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
		return service.saveFuncionario(funcionario);
	}

	@DeleteMapping("/{id}")
	public void deleteFuncionario(@PathVariable Long id) {
		service.deleteFuncionario(id);
	}

	@GetMapping
	public ResponseEntity<List<Funcionario>> getAllFuncionario(RequestEntity<Void> requestEntity) {
		String method = requestEntity.getMethod().name();
		String contentType = requestEntity.getHeaders().getContentType().toString();
		List<Funcionario> funcionario = service.getAllFuncionario();
		return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
				.body(funcionario);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> getFuncionario(@PathVariable Long id) {
		Funcionario funcionario = service.getFuncionarioById(id);
		if (funcionario != null) {
			return ResponseEntity.ok(funcionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{id}")
	public Funcionario updateFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
		return service.updateFuncionario(id, funcionario);
	}

}
