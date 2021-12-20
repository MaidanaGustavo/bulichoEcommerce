package bulicho.ecommerce.bulicho.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bulicho.ecommerce.bulicho.dto.MarcaDTO;
import bulicho.ecommerce.bulicho.entities.Marca;
import bulicho.ecommerce.bulicho.repositories.MarcaRepository;
import bulicho.ecommerce.bulicho.services.interfaces.IMarcaService;

@Service
public class MarcaService implements IMarcaService {

  @Autowired
  private MarcaRepository marcaRepository;

  @Override
  public List<Marca> listAll() {
    return marcaRepository.findAll();
  }

  @Override
  public Marca get(UUID id) {
    try{
      return marcaRepository.findById(id).get();
    }catch(Exception e){
      return null;
    }
  }

  @Override
  public UUID create(MarcaDTO departamentoDTO) {
    return marcaRepository.save(new Marca(departamentoDTO)).getId();
  }

  @Override
  public Boolean marcaExists(UUID id) {
    return marcaRepository.existsById(id);
  }

  @Override
  public Marca update(UUID id, MarcaDTO marcaDTO) {
    try {
      Marca marca = marcaRepository.findById(id).get();
      marca.setNome(
        marcaDTO.getNome()==null?
        marca.getNome():marcaDTO.getNome()
      );
      marcaRepository.save(marca);
      return marca;
    } catch (Exception e) {
      return null;
    }
    
  }

  @Override
  public void delete(UUID id) {
    try {
      marcaRepository.deleteById(id);
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
  
}
