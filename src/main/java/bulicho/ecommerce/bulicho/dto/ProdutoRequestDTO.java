package bulicho.ecommerce.bulicho.dto;

import java.util.List;
import java.util.UUID;

import bulicho.ecommerce.bulicho.entities.FotoProduto;

public class ProdutoRequestDTO {
  private Long codigo;
  private String titulo;
  private Double preco;
  private Long quantidadeEmEstoque;
  private String descricao;
  private String caminhoFotoPrincipal;
  private UUID marca;
  private List<Long> categorias;
  private List<FotoProduto> fotos;

  public ProdutoRequestDTO() {
  }

  public ProdutoRequestDTO(Long codigo, String titulo, Double preco, Long quantidadeEmEstoque, String descricao, String caminhoFotoPrincipal, UUID marca, List<Long> categorias, List<FotoProduto> fotos) {
    this.codigo = codigo;
    this.titulo = titulo;
    this.preco = preco;
    this.quantidadeEmEstoque = quantidadeEmEstoque;
    this.descricao = descricao;
    this.caminhoFotoPrincipal = caminhoFotoPrincipal;
    this.marca = marca;
    this.categorias = categorias;
    this.fotos = fotos;
  }

  public ProdutoRequestDTO(Long codigo, String titulo, Double preco, Long quantidadeEmEstoque, String descricao, String caminhoFotoPrincipal, UUID marca, List<Long> categorias) {
    this.codigo = codigo;
    this.titulo = titulo;
    this.preco = preco;
    this.quantidadeEmEstoque = quantidadeEmEstoque;
    this.descricao = descricao;
    this.caminhoFotoPrincipal = caminhoFotoPrincipal;
    this.marca = marca;
    this.categorias = categorias; 
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

  public UUID getMarca() {
    return this.marca;
  }

  public void setMarca(UUID marca) {
    this.marca = marca;
  }

  public List<Long> getCategorias() {
    return this.categorias;
  }

  public void setCategorias(List<Long> categorias) {
    this.categorias = categorias;
  }

  public List<FotoProduto> getFotos() {
    return this.fotos;
  }

  public void setFotos(List<FotoProduto> fotos) {
    this.fotos = fotos;
  }

}
