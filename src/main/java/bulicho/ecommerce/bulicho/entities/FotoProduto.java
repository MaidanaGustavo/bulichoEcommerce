package bulicho.ecommerce.bulicho.entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import bulicho.ecommerce.bulicho.dto.FotoProdutoDTO;

@Entity(name = "foto_produto")
public class FotoProduto {
  
  @Id
  @GeneratedValue
  private UUID id;
  private String caminho;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "id_produto")
  private Produto produto;

  public FotoProduto(){}

  public FotoProduto(UUID id, String caminho, Produto produto){
    this.id = id;
    this.caminho = caminho;
    this.produto = produto;
  }

   public FotoProduto(FotoProdutoDTO fotoProdutoDTO){
     this.caminho = fotoProdutoDTO.getCaminho();
     this.produto = fotoProdutoDTO.getProduto();
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

  public Produto getProduto() {
    return this.produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

}
