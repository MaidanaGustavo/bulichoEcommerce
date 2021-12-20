package bulicho.ecommerce.bulicho.entities;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import bulicho.ecommerce.bulicho.dto.MarcaDTO;

@Entity
public class Marca implements Serializable{
  
  @Id
  @GeneratedValue
  private UUID id;
  private String nome;

  public Marca(){}
  public Marca(UUID id, String nome){
    this.id = id;
    this.nome = nome;
  }

  public Marca(MarcaDTO marcaDTO){
    this.nome = marcaDTO.getNome();
  }
  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

}
