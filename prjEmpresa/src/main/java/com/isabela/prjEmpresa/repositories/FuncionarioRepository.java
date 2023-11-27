package com.isabela.prjEmpresa.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.isabela.prjEmpresa.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}

