package bulicho.ecommerce.bulicho.entities;


import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import bulicho.ecommerce.bulicho.dto.ProdutoDTO;

@Entity
public class Produto implements Serializable {
 
  @Id
  @GeneratedValue
  private UUID id;
  private Long codigo;
  private String titulo;
  private Double preco;
  @Column(name = "quantidade_em_estoque")
  private Long quantidadeEmEstoque;
  private String descricao;
  @Column(name = "caminho_foto_principal")
  private String caminhoFotoPrincipal;
  @ManyToOne
  @JoinColumn(name = "id_marca")
  private Marca marca;
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
    name = "produtos_categorias",
    joinColumns = @JoinColumn(name="id_produto"),
    inverseJoinColumns = @JoinColumn(name = "id_categoria")
  )
  private List<Categoria> categorias;

  @OneToMany()
  @JoinColumn(name = "id_produto" )
  @LazyCollection(LazyCollectionOption.FALSE)
  private List<FotoProduto> fotos;

  

  public Produto(){}

  public Produto(ProdutoDTO produtoDTO){
    this.codigo = produtoDTO.getCodigo();
    this.titulo = produtoDTO.getTitulo();
    this.preco = produtoDTO.getPreco();
    this.quantidadeEmEstoque = produtoDTO.getQuantidadeEmEstoque();
    this.descricao = produtoDTO.getDescricao();
    this.caminhoFotoPrincipal = produtoDTO.getCaminhoFotoPrincipal();
    this.marca  = produtoDTO.getMarca();
    this.categorias = produtoDTO.getCategorias();
    this.fotos = produtoDTO.getFotos();
  }
  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Long getCodigo() {
    return this.codigo;
  }

  public void setCodigo(Long codigo) {
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

  public List<FotoProduto> getFotos() {
    return this.fotos;
  }

  public void setFotos(List<FotoProduto> fotos) {
    this.fotos = fotos;
  }

}
