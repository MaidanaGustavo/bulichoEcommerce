package bulicho.ecommerce.bulicho.dto;

import java.util.UUID;

import bulicho.ecommerce.bulicho.entities.FotoProduto;

public class FotoProdutoResponseByProdutoDTO {
  
  private UUID id;
  private String caminho;


  public FotoProdutoResponseByProdutoDTO() {
  }

  public FotoProdutoResponseByProdutoDTO(FotoProduto fotoProduto){
    this.id = fotoProduto.getId();
    this.caminho = fotoProduto.getCaminho();
  }

  public FotoProdutoResponseByProdutoDTO(UUID id, String caminho) {
    this.id = id;
    this.caminho = caminho;
  }

  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getCaminho() {
    return this.caminho;
  }

  public void setCaminho(String caminho) {
    this.caminho = caminho;
  }

}