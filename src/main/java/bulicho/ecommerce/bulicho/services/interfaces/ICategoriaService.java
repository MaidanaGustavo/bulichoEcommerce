package bulicho.ecommerce.bulicho.services.interfaces;

import java.util.List;

import bulicho.ecommerce.bulicho.dto.CategoriaDTO;
import bulicho.ecommerce.bulicho.entities.Categoria;

public interface ICategoriaService {
  public List<Categoria> listAll();
  public Categoria getCategoria(Long id);
  public Long createCategoria(CategoriaDTO categoriaDto);
  public Boolean categoriaExists(Long id);
  public Categoria updateCategoria(Long id, CategoriaDTO categoriaDto);
  public void deleteCategoria(Long id);
}
