package bulicho.ecommerce.bulicho.entities;


import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Produto implements Serializable {
 
  @Id
  @GeneratedValue
  private UUID id;
  private Integer codigo;
  private String titulo;
  private Double preco;
  @Column(name = "quantidade_em_estoque")
  private Long quantidadeEmEstoque;
  private String descricao;
  @Column(name = "caminho_foto_principal")
  private String caminhoFotoPrincipal;
  private Marca marca;
  @ManyToMany
  @JoinTable(
    name = "produtos_categorias",
    joinColumns = @JoinColumn(name="id_produto"),
    inverseJoinColumns = @JoinColumn(name = "id_categoria")
  )
  private List<Categoria> categorias;

  @OneToMany
  @JoinColumn(name = "id_produto" )
  private List<FotoProduto> fotos;

  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Integer getCodigo() {
    return this.codigo;
  }

  public void setCodigo(Integer codigo) {
    this.codigo = codigo;
  }

  public String getTitulo() {
    return this.titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public Double getPreco() {
    return this.preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }

  public Long getQuantidadeEmEstoque() {
    return this.quantidadeEmEstoque;
  }

  public void setQuantidadeEmEstoque(Long quantidadeEmEstoque) {
    this.quantidadeEmEstoque = quantidadeEmEstoque;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getCaminhoFotoPrincipal() {
    return this.caminhoFotoPrincipal;
  }

  public void setCaminhoFotoPrincipal(String caminhoFotoPrincipal) {
    this.caminhoFotoPrincipal = caminhoFotoPrincipal;
  }

  public Marca getMarca() {
    return this.marca;
  }

  public void setMarca(Marca marca) {
    this.marca = marca;
  }
  public List<Categoria> getCategorias() {
    return this.categorias;
  }

  public void setCategorias(List<Categoria> categorias) {
    this.categorias = categorias;
  }

}
