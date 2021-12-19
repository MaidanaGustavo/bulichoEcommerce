package bulicho.ecommerce.bulicho.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class DepartamentoDTO {

  @ApiModelProperty(
    value = "O nome do departamento que será criado",
    name = "nome",
    dataType = "String",
    required = true,
    position = 1
  )
  private String nome;

  public DepartamentoDTO(){}
  public DepartamentoDTO(String nome){
    this.nome = nome;
  }
  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }


}
