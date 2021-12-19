package bulicho.ecommerce.bulicho.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import bulicho.ecommerce.bulicho.dto.CategoriaDTO;

@Entity
public class Categoria implements Serializable {
  

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;

  @ManyToOne
  @JoinColumn(name = "id_departamento")
  private Departamento departamento;
  
  public Categoria(){}
  public Categoria(Long id,String nome){
    this.id = id;
    this.nome = nome;
  }

  public Categoria(CategoriaDTO  categoriaDTO){
    this.nome = categoriaDTO.getNome();
    this.departamento = categoriaDTO.getDepartamento();
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

  public Departamento getDepartamento() {
    return this.departamento;
  }

  public void setDepartamento(Departamento departamento) {
    this.departamento = departamento;
  }

}
