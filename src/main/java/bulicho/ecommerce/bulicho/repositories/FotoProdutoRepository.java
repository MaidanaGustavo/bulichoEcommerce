package bulicho.ecommerce.bulicho.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bulicho.ecommerce.bulicho.entities.FotoProduto;
@Repository
public interface FotoProdutoRepository extends JpaRepository<FotoProduto,UUID>{
  
}
