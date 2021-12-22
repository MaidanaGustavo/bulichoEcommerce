package bulicho.ecommerce.bulicho.dto;

import bulicho.ecommerce.bulicho.entities.Produto;

public class FotoProdutoDTO {
  private String caminho;
  private Produto produto;

  public FotoProdutoDTO() {
  }

  public FotoProdutoDTO(String caminho, Produto produto) {
    this.caminho = caminho;
    this.produto = produto;
  }

  public String getCaminho() {
    return this.caminho;
  }

  public void setCaminho(String caminho) {
    this.caminho = caminho;
  }

  public Produto getProduto() {
    return this.produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

}
