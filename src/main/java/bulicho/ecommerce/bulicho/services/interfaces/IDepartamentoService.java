package bulicho.ecommerce.bulicho.services.interfaces;

import java.util.List;

import bulicho.ecommerce.bulicho.dto.DepartamentoDTO;
import bulicho.ecommerce.bulicho.entities.Departamento;

public interface IDepartamentoService {
  
  public List<Departamento> listAll();
  public Departamento get(Long id);
  public Long create(DepartamentoDTO departamentoDTO);
  public Boolean departamentoExists(Long id);
  public Departamento update(Long id,DepartamentoDTO departamentoDTO);
  public void delete(Long id);
}
