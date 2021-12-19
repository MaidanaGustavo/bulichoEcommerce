package bulicho.ecommerce.bulicho.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bulicho.ecommerce.bulicho.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
  
}
