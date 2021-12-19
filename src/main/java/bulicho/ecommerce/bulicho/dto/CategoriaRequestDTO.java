package bulicho.ecommerce.bulicho.dto;

public class CategoriaRequestDTO {
  
  private String nome;
  private Long idDepartamento;

  public CategoriaRequestDTO(){}

  public CategoriaRequestDTO(String nome,Long idDepartamento){
    this.nome = nome;
    this.idDepartamento = idDepartamento;
  }
  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Long getIdDepartamento() {
    return this.idDepartamento;
  }

  public void setIdDepartamento(Long idDepartamento) {
    this.idDepartamento = idDepartamento;
  }

}
