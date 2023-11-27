package com.isabela.prjEmpresa.entities;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name="tb_Funcionario")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long funCodigo;
	
	@NotNull
	@NotBlank
	private String funNome;
	
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate funNascimento;
	
	@NotNull
	@NotBlank
	private double funSalario;
	
	
	public Funcionario() {
		
	}
	
	public Funcionario(Long funCodigo, String funNome, LocalDate funNascimento, double funSalario) {
		super();
		this.funCodigo = funCodigo;
		this.funNome = funNome;
		this.funNascimento = funNascimento;
		this.funSalario = funSalario;
	}

	public Long getFuncodigo() {
		return funCodigo;
	}

	public void setFuncodigo(Long funCodigo) {
		this.funCodigo = funCodigo;
	}
	

	public String getFunnome() {
		return funNome;
	}

	public void setFunnome(String funNome) {
		this.funNome = funNome;
	}
	
	public LocalDate getFunnascimento() {
		return funNascimento;
	}

	public void setFunnascimento(LocalDate funNascimento) {
		this.funNascimento = funNascimento;
	}
	
	public double getFunsalario() {
		return funSalario;
	}

	public void setFunsalario(double funSalario) {
		this.funSalario = funSalario;
	}


}
