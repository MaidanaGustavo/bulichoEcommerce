package bulicho.ecommerce.bulicho.dto;

import bulicho.ecommerce.bulicho.entities.Departamento;

public class CategoriaDTO {
  
  private String nome;
  private Departamento departamento;
  public CategoriaDTO(){}
  public CategoriaDTO(String nome,Departamento departamento){
    this.nome = nome;
    this.departamento = departamento;
  }
  public Departamento getDepartamento() {
    return this.departamento;
  }

  public void setDepartamento(Departamento departamento) {
    this.departamento = departamento;
  }
  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
  @Override
  public String toString(){
    return ""+this.nome
    +"\n Departamento : "+" "+this.departamento.getId()+" "+this.departamento.getNome()+" ";
  }

}
