package bulicho.ecommerce.bulicho.entities;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import bulicho.ecommerce.bulicho.dto.DepartamentoDTO;

@Entity
public class Departamento implements Serializable{
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
	public Departamento(){}
	public Departamento(DepartamentoDTO departamentoDTO){
		this.nome = departamentoDTO.getNome();
	}
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
