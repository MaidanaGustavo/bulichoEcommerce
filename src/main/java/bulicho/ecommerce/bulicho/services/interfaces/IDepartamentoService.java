package bulicho.ecommerce.bulicho.services.interfaces;

import java.util.List;

import bulicho.ecommerce.bulicho.dto.DepartamentoDTO;
import bulicho.ecommerce.bulicho.entities.Departamento;

public interface IDepartamentoService {
  
  public List<Departamento> listAll();
  public Departamento getDepartamento(Long id);
  public Long createDepartamento(DepartamentoDTO departamentoDTO);
  public Boolean departamentoExists(Long id);
  public Departamento updateDepartamento(Long id,DepartamentoDTO departamentoDTO);
  public void deleteDepartamento(Long id);
}
