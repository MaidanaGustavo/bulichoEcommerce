package bulicho.ecommerce.bulicho.dto;

import java.util.List;

import bulicho.ecommerce.bulicho.entities.Categoria;
import bulicho.ecommerce.bulicho.entities.FotoProduto;
import bulicho.ecommerce.bulicho.entities.Marca;

public class ProdutoDTO {
  
  private Long codigo;
  private String titulo;
  private Double preco;
  private Long quantidadeEmEstoque;
  private String descricao;
  private String caminhoFotoPrincipal;
  private Marca marca;
  private List<Categoria> categorias;
  private List<FotoProduto> fotos;

  public ProdutoDTO(Long codigo, String titulo, Double preco, Long quantidadeEmEstoque, String descricao, String caminhoFotoPrincipal, Marca marca, List<Categoria> categorias, List<FotoProduto> fotos) {
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

  public ProdutoDTO(Long codigo, String titulo, Double preco, Long quantidadeEmEstoque, String descricao, String caminhoFotoPrincipal, Marca marca, List<Categoria> categorias) {
    this.codigo = codigo;
    this.titulo = titulo;
    this.preco = preco;
    this.quantidadeEmEstoque = quantidadeEmEstoque;
    this.descricao = descricao;
    this.caminhoFotoPrincipal = caminhoFotoPrincipal;
    this.marca = marca;
    this.categorias = categorias;
  }

  public ProdutoDTO(ProdutoRequestDTO produtoRequestDTO){
    this.codigo = produtoRequestDTO.getCodigo();
    this.titulo = produtoRequestDTO.getTitulo();
    this.preco = produtoRequestDTO.getPreco();
    this.quantidadeEmEstoque = produtoRequestDTO.getQuantidadeEmEstoque();
    this.descricao = produtoRequestDTO.getDescricao();
    this.caminhoFotoPrincipal = produtoRequestDTO.getCaminhoFotoPrincipal();
    this.fotos = produtoRequestDTO.getFotos();
  }

  public ProdutoDTO(){}

  
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
