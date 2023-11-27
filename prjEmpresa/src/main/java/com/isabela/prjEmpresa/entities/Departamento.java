package com.isabela.prjEmpresa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name="tb_Departamento")
public class Departamento {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long depCodigo;
		
		@NotNull
		@NotBlank
		private String depNome;
		
		
		public Departamento() {
			
		}
		
		public Departamento(Long depCodigo, String depNome) {
			super();
			this.depCodigo = depCodigo;
			this.depNome = depNome;
		}

		public Long getDepcodigo() {
			return depCodigo;
		}

		public void setDepCodigo(Long depCodigo) {
			this.depCodigo = depCodigo;
		}
		

		public String getDepnome() {
			return depNome;
		}

		public void setDepNome(String depNome) {
			this.depNome = depNome;
		}

		
		
	}

