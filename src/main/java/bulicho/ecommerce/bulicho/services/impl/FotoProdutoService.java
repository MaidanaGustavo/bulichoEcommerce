package bulicho.ecommerce.bulicho.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bulicho.ecommerce.bulicho.dto.FotoProdutoDTO;
import bulicho.ecommerce.bulicho.entities.FotoProduto;
import bulicho.ecommerce.bulicho.entities.Produto;
import bulicho.ecommerce.bulicho.repositories.FotoProdutoRepository;
import bulicho.ecommerce.bulicho.services.interfaces.IFotoProdutoService;

@Service
public class FotoProdutoService implements IFotoProdutoService {

  @Autowired
  private FotoProdutoRepository fotoProdutoRepository;

  @Override
  public List<FotoProduto> listAll() {
    return fotoProdutoRepository.findAll();
  }

  @Override
  public FotoProduto get(UUID id) {
    
    try {
      return fotoProdutoRepository.findById(id).get();
    } catch (Exception e) {
      return null;
    }

  }

  @Override
  public UUID create(FotoProdutoDTO fotoProdutoDTO) {
    
    try {
      return fotoProdutoRepository.save(new FotoProduto(fotoProdutoDTO)).getId();
    } catch (Exception e) {
      return null;
    }

  }

  @Override
  public Boolean fotoProdutoExists(UUID id) {
    return fotoProdutoRepository.existsById(id);
  }

  @Override
  public FotoProduto update(UUID id, FotoProdutoDTO fotoProdutoDTO) {
    try {
      FotoProduto fotoProduto = fotoProdutoRepository.findById(id).get();

      fotoProduto.setCaminho(
        fotoProdutoDTO.getCaminho()==null?
        fotoProduto.getCaminho():fotoProdutoDTO.getCaminho()
      );

      fotoProduto.setProduto(
        fotoProdutoDTO.getProduto()==null?
        fotoProduto.getProduto():fotoProdutoDTO.getProduto()
      );
      fotoProdutoRepository.save(fotoProduto);
      return fotoProduto;
    } catch (Exception e) {
      return null;
    }
    
  }

  @Override
  public void delete(UUID id) {
    fotoProdutoRepository.deleteById(id);
  }

  @Override
  public List<FotoProduto> findByProduto(Produto produto) {
   try {
     return fotoProdutoRepository.findByProduto(produto);
   } catch (Exception e) {
     return null;
   }
  }
  
}
