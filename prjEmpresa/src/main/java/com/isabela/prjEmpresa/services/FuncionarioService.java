package com.isabela.prjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.isabela.prjEmpresa.entities.Funcionario;
import com.isabela.prjEmpresa.repositories.FuncionarioRepository;




@org.springframework.stereotype.Service
public class FuncionarioService {
	
	
	private final FuncionarioRepository repository;
	
	@Autowired
	public FuncionarioService(FuncionarioRepository repository) {
		this.repository = repository;
	}
	
	public Funcionario getFuncionarioById(Long funCodigo) {
		return repository.findById(funCodigo).orElse(null);
	}
	
	public List<Funcionario> getAllFuncionario(){
		return repository.findAll();
	}


	public Funcionario saveFuncionario(Funcionario funcionario) {
		return repository.save(funcionario);
	}
	
	public void deleteFuncionario(Long id) {
		repository.deleteById(id);
	}
	
	public Funcionario updateFuncionario(Long id, Funcionario novoFuncionario) {
        Optional<Funcionario> funcionarioOptional = repository.findById(id);
        if (funcionarioOptional.isPresent()) {
        	Funcionario funcionarioExistente = funcionarioOptional.get();
           	funcionarioExistente.setFuncodigo(novoFuncionario.getFuncodigo());
        	funcionarioExistente.setFunnome(novoFuncionario.getFunnome());
        	funcionarioExistente.setFunnascimento(novoFuncionario.getFunnascimento());
        	funcionarioExistente.setFunsalario(novoFuncionario.getFunsalario());
            return repository.save(funcionarioExistente); 
        } else {
            return null; 
        }
    }


}
