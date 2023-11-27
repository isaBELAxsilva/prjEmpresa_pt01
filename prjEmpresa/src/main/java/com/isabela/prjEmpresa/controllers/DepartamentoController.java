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

import com.isabela.prjEmpresa.entities.Departamento;
import com.isabela.prjEmpresa.services.DepartamentoService;




@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
	
	private final DepartamentoService service;

	@GetMapping("/home")
	public String paginaInicial() {
		return "index";
	}

	@Autowired
	public DepartamentoController(DepartamentoService service) {
		this.service = service;
	}

	@PostMapping
	public Departamento createDepartamento(@RequestBody Departamento departamento) {
		return service.saveDepartamento(departamento);
	}

	@DeleteMapping("/{id}")
	public void deleteDepartamento(@PathVariable Long id) {
		service.deleteDepartamento(id);
	}

	@GetMapping
	public ResponseEntity<List<Departamento>> getAllDepartamento(RequestEntity<Void> requestEntity) {
		String method = requestEntity.getMethod().name();
		String contentType = requestEntity.getHeaders().getContentType().toString();
		List<Departamento> departamento = service.getAllDepartamento();
		return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
				.body(departamento);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Departamento> getDepartamento(@PathVariable Long id) {
		Departamento departamento = service.getDepartamentoById(id);
		if (departamento != null) {
			return ResponseEntity.ok(departamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{id}")
	public Departamento updateDepartamento(@PathVariable Long id, @RequestBody Departamento departamento) {
		return service.updateDepartamento(id, departamento);
	}

 }
