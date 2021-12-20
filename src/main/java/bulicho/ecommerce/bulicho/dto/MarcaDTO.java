package bulicho.ecommerce.bulicho.dto;

public class MarcaDTO {
  
  private String nome;

  public MarcaDTO(){}
  public MarcaDTO(String nome){
    this.nome = nome;
  }
  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

}
