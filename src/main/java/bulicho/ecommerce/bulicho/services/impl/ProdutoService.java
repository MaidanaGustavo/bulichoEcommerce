package bulicho.ecommerce.bulicho.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bulicho.ecommerce.bulicho.dto.ProdutoDTO;
import bulicho.ecommerce.bulicho.entities.Produto;
import bulicho.ecommerce.bulicho.repositories.ProdutoRepository;
import bulicho.ecommerce.bulicho.services.interfaces.IProdutoService;

@Service
public class ProdutoService implements IProdutoService {

  @Autowired
  private ProdutoRepository produtoRepository;

  @Override
  public List<Produto> listAll() {
    return produtoRepository.findAll();
  }

  @Override
  public Produto get(UUID id) {
    try {
      return produtoRepository.findById(id).get();
    } catch (Exception e) {
      return null;
    }
    
  }

  @Override
  public UUID create(ProdutoDTO produtoDTO) {
    try {
      return produtoRepository.save(new Produto(produtoDTO)).getId();
    } catch (Exception e) {
      return null;
    }
  }

  @Override
  public Boolean produtoExists(UUID id) {
    return produtoRepository.existsById(id);
  }

  @Override
  public Produto update(UUID id, ProdutoDTO produtoDTO) {
    Produto produto = produtoRepository.findById(id).get();

    produto.setCodigo(
      produtoDTO.getCodigo()==null?
      produto.getCodigo():produtoDTO.getCodigo()
    );
    produto.setTitulo(
      produtoDTO.getTitulo()==null?
      produto.getTitulo():produtoDTO.getTitulo()
    );
    produto.setPreco(
      produtoDTO.getPreco()==null?
      produto.getPreco():produtoDTO.getPreco()
    );
    produto.setQuantidadeEmEstoque(
      produtoDTO.getQuantidadeEmEstoque()==null?
      produto.getQuantidadeEmEstoque():produtoDTO.getQuantidadeEmEstoque()
    );
    produto.setDescricao(
      produtoDTO.getDescricao()==null?
      produto.getDescricao():produtoDTO.getDescricao()
    );
    produto.setCaminhoFotoPrincipal(
      produtoDTO.getCaminhoFotoPrincipal()==null?
      produto.getCaminhoFotoPrincipal():produtoDTO.getCaminhoFotoPrincipal()
    );
    produto.setMarca(
      produtoDTO.getMarca()==null?
      produto.getMarca():produtoDTO.getMarca()
    );
    produto.setCategorias(
      produtoDTO.getCategorias()==null || produtoDTO.getCategorias().isEmpty()?
      produto.getCategorias():produtoDTO.getCategorias()
    );
    produto.setFotos(
      produtoDTO.getFotos()==null?
      produto.getFotos():produtoDTO.getFotos()
    );

    produtoRepository.save(produto);

    return produto;
  }

  @Override
  public void delete(UUID id) {
    
    try {
      produtoRepository.deleteById(id);
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
  
}
