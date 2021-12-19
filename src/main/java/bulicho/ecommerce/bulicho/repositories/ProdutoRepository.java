package bulicho.ecommerce.bulicho.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import bulicho.ecommerce.bulicho.entities.Produto;

public interface  ProdutoRepository  extends JpaRepository<Produto, UUID>{
  
}
