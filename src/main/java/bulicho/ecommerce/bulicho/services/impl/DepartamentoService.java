package bulicho.ecommerce.bulicho.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bulicho.ecommerce.bulicho.dto.DepartamentoDTO;
import bulicho.ecommerce.bulicho.entities.Departamento;
import bulicho.ecommerce.bulicho.repositories.DepartamentoRepository;
import bulicho.ecommerce.bulicho.services.interfaces.IDepartamentoService;

@Service
public class DepartamentoService implements IDepartamentoService{

  @Autowired
  private DepartamentoRepository departamentoRepository;
  
  @Override
  public List<Departamento> listAll() {
    return departamentoRepository.findAll();
  }

  @Override
  public Departamento get(Long id) {
    Departamento dep;
    try {
       dep = departamentoRepository.findById(id).get();
    } catch (Exception e) {
      dep = null;
    }
    return dep;
  }

  @Override
  public Long create(DepartamentoDTO departamentoDTO) {
    Long id = departamentoRepository.save(new Departamento(departamentoDTO)).getId();
    return  id;
  }

  @Override
  public Boolean departamentoExists(Long id) {
     return departamentoRepository.existsById(id);
  }

  @Override
  public Departamento update(Long id, DepartamentoDTO departamentoDTO) {
    Departamento departamento = departamentoRepository.findById(id).get();
    departamento.setNome(
      departamentoDTO.getNome()==null?departamento.getNome():departamentoDTO.getNome()
    );
    departamentoRepository.save(departamento);
    return departamento;
  }

  @Override
  public void delete(Long id) {
    departamentoRepository.deleteById(id);    
  }
  
}
