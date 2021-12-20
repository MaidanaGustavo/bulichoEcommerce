package bulicho.ecommerce.bulicho.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bulicho.ecommerce.bulicho.dto.CategoriaDTO;
import bulicho.ecommerce.bulicho.entities.Categoria;
import bulicho.ecommerce.bulicho.repositories.CategoriaRepository;
import bulicho.ecommerce.bulicho.services.interfaces.ICategoriaService;

@Service
public class CategoriaService implements ICategoriaService {

  @Autowired
  private CategoriaRepository categoriaRepository;

  @Override
  public List<Categoria> listAll() {
    return categoriaRepository.findAll();
  }

  @Override
  public Categoria get(Long id) {
    Categoria categoria;
    try{
      categoria = categoriaRepository.findById(id).get();
    }catch(Exception e){
      categoria = null;
    }
    return categoria;
  }

  @Override
  public Long create(CategoriaDTO categoriaDTO) {
    Long id = categoriaRepository.save(new Categoria(categoriaDTO)).getId();
    return id;
  }

  @Override
  public Boolean categoriaExists(Long id) {
    return categoriaRepository.existsById(id);
  }

  @Override
  public Categoria update(Long id, CategoriaDTO categoriaDto) {
    Categoria categoria ;
    try{
      categoria = categoriaRepository.findById(id).get();
      categoria.setNome(
        categoriaDto.getNome()==null?
        categoria.getNome():categoriaDto.getNome()
      );

      categoria.setDepartamento(
        categoriaDto.getDepartamento()==null?
        categoria.getDepartamento():categoriaDto.getDepartamento()
      );

      categoriaRepository.save(categoria);
    }catch(Exception e){
      System.out.println(e.getMessage());
      categoria = null;
    }
    return categoria;
  }

  @Override
  public void delete(Long id) {
    categoriaRepository.deleteById(id);
  }
  
}
