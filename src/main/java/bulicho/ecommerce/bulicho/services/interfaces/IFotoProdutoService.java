package bulicho.ecommerce.bulicho.services.interfaces;

import java.util.List;
import java.util.UUID;

import bulicho.ecommerce.bulicho.dto.FotoProdutoDTO;
import bulicho.ecommerce.bulicho.entities.FotoProduto;
import bulicho.ecommerce.bulicho.entities.Produto;

public interface IFotoProdutoService {
  public List<FotoProduto> listAll();
  public FotoProduto get(UUID id);
  public UUID create(FotoProdutoDTO fotoProdutoDTO);
  public Boolean fotoProdutoExists(UUID id);
  public FotoProduto update(UUID id,FotoProdutoDTO fotoProdutoDTO);
  public void delete(UUID id);
  public List<FotoProduto>  findByProduto(Produto produto);
}
