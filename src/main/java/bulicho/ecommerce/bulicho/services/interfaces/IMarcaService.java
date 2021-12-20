package bulicho.ecommerce.bulicho.services.interfaces;

import java.util.List;
import java.util.UUID;

import bulicho.ecommerce.bulicho.dto.MarcaDTO;
import bulicho.ecommerce.bulicho.entities.Marca;

public interface IMarcaService {
  public List<Marca> listAll();
  public Marca get(UUID id);
  public UUID create(MarcaDTO departamentoDTO);
  public Boolean marcaExists(UUID id);
  public Marca update(UUID id,MarcaDTO marcaDTO);
  public void delete(UUID id);
}
