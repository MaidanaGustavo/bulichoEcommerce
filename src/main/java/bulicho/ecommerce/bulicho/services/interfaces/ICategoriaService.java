package bulicho.ecommerce.bulicho.services.interfaces;

import java.util.List;

import bulicho.ecommerce.bulicho.dto.CategoriaDTO;
import bulicho.ecommerce.bulicho.entities.Categoria;


public interface ICategoriaService {
  public List<Categoria> listAll();
  public Categoria get(Long id);
  public Long create(CategoriaDTO categoriaDto);
  public Boolean categoriaExists(Long id);
  public Categoria update(Long id, CategoriaDTO categoriaDto);
  public void delete(Long id);
}
