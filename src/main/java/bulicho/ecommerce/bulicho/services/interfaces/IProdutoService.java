package bulicho.ecommerce.bulicho.services.interfaces;

import java.util.List;
import java.util.UUID;

import bulicho.ecommerce.bulicho.dto.ProdutoDTO;
import bulicho.ecommerce.bulicho.entities.Produto;

public interface IProdutoService {
  public List<Produto> listAll();
  public Produto get(UUID id);
  public UUID create(ProdutoDTO produtoDTO);
  public Boolean produtoExists(UUID id);
  public Produto update(UUID id,ProdutoDTO produtoDTO);
  public void delete(UUID id);
}
