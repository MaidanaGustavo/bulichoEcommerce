package bulicho.ecommerce.bulicho.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import bulicho.ecommerce.bulicho.entities.FotoProduto;

public interface FotoProdutoRepository extends JpaRepository<FotoProduto,UUID>{
  
}
