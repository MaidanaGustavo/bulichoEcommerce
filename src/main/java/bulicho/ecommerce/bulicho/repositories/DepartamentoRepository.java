package bulicho.ecommerce.bulicho.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bulicho.ecommerce.bulicho.entities.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{
  
}
