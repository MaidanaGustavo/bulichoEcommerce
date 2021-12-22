package bulicho.ecommerce.bulicho.dto;

import java.util.UUID;

public class FotoProdutoRequestDTO {
  
  private String caminho;
  private UUID idProduto;

  public FotoProdutoRequestDTO(String caminho, UUID idCaminho) {
    this.caminho = caminho;
    this.idProduto = idCaminho;
  }

  public FotoProdutoRequestDTO() {
  }

  public String getCaminho() {
    return this.caminho;
  }

  public void setCaminho(String caminho) {
    this.caminho = caminho;
  }

  public UUID getIdProduto() {
    return this.idProduto;
  }

  public void setIdProduto(UUID idProduto) {
    this.idProduto = idProduto;
  }


}
