package bulicho.ecommerce.bulicho.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bulicho.ecommerce.bulicho.entities.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{
  
}
