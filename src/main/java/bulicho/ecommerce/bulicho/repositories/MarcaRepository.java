package bulicho.ecommerce.bulicho.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import bulicho.ecommerce.bulicho.entities.Marca;

public interface MarcaRepository extends JpaRepository<Marca,UUID> {
  
}
