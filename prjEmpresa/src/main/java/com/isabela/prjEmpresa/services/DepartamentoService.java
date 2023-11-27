package com.isabela.prjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.isabela.prjEmpresa.entities.Departamento;
import com.isabela.prjEmpresa.repositories.DepartamentoRepository;


@org.springframework.stereotype.Service
public class DepartamentoService {
	
	private final DepartamentoRepository repository;
		
		@Autowired
		public DepartamentoService(DepartamentoRepository repository) {
			this.repository = repository;
		}
		
		public Departamento getDepartamentoById(Long depCodigo) {
			return repository.findById(depCodigo).orElse(null);
		}
		
		public List<Departamento> getAllDepartamento(){
			return repository.findAll();
		}
		
		public Departamento saveDepartamento(Departamento departamento) {
			return repository.save(departamento);
		}
		
		public void deleteDepartamento(Long id) {
			repository.deleteById(id);
		}
		
		public Departamento updateDepartamento(Long id, Departamento novoDepartamento) {
	        Optional<Departamento> departamentoOptional = repository.findById(id);
	        if (departamentoOptional.isPresent()) {
	        	Departamento departamentoExistente = departamentoOptional.get();
	           	departamentoExistente.setDepCodigo(novoDepartamento.getDepcodigo());
	        	departamentoExistente.setDepNome(novoDepartamento.getDepnome());          
	            return repository.save(departamentoExistente); 
	        } else {
	            return null; 
	        }
	    }

}
