package bulicho.ecommerce.bulicho.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bulicho.ecommerce.bulicho.entities.FotoProduto;
import bulicho.ecommerce.bulicho.entities.Produto;
@Repository
public interface FotoProdutoRepository extends JpaRepository<FotoProduto,UUID>{
  
  List<FotoProduto> findByProduto(Produto produto);
  
}
