package bulicho.ecommerce.bulicho.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bulicho.ecommerce.bulicho.dto.ProdutoDTO;
import bulicho.ecommerce.bulicho.dto.ProdutoRequestDTO;
import bulicho.ecommerce.bulicho.entities.Categoria;
import bulicho.ecommerce.bulicho.entities.FotoProduto;
import bulicho.ecommerce.bulicho.entities.Marca;
import bulicho.ecommerce.bulicho.entities.Produto;
import bulicho.ecommerce.bulicho.models.ResponseModel;
import bulicho.ecommerce.bulicho.services.interfaces.ICategoriaService;
import bulicho.ecommerce.bulicho.services.interfaces.IMarcaService;
import bulicho.ecommerce.bulicho.services.interfaces.IProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "Produto")
@RequestMapping("/api/produtos")
public class ProdutoController {
  
  @Autowired
  private IProdutoService produtoService;
  @Autowired
  private IMarcaService  marcaService;

  @Autowired
  private ICategoriaService categoriaService;

  @GetMapping
  @ApiOperation(value = "Busca todos os produtos")
  public ResponseEntity<ResponseModel<Produto>> listAllProdutos(){
    List<Produto> data = produtoService.listAll();
    ResponseModel<Produto> response  =  new ResponseModel<Produto>(200,"Sucesso",data);

    return new ResponseEntity<ResponseModel<Produto>>(response,HttpStatus.OK);
  }

  @GetMapping("/{id}")
  @ApiOperation(value = "Busca um produto pelo id")
  public ResponseEntity<ResponseModel<Produto>> getProduto(@ApiParam(value = "Id do produto") @PathVariable("id") UUID id ){
    List<Produto> data = new ArrayList<Produto>();
    ResponseModel<Produto> response ;
    
    if(!produtoService.produtoExists(id)){
      response = new ResponseModel<Produto>(404,"Produto não encontrado",data);
      return new ResponseEntity<ResponseModel<Produto>>(response,HttpStatus.NOT_FOUND);
    }
    
    Produto produto  = produtoService.get(id);
    data.add(produto);
    response = new ResponseModel<Produto>(200,"Sucesso",data);

    return new ResponseEntity<ResponseModel<Produto>>(response,HttpStatus.OK);
  }

  @PostMapping
  @ApiOperation(value = "Cria um produto")
  public ResponseEntity<ResponseModel<Produto>> createProduto(@RequestBody ProdutoRequestDTO  produtoRequestDTO){
    List<Produto> data = new ArrayList<Produto>();
    ResponseModel<Produto> response ;
    Marca marca = null;
    List<Categoria> categorias = new ArrayList<>();
    List<FotoProduto> fotos ;
    try {

     if(produtoRequestDTO.getMarca()!=null){
       marca = marcaService.get(produtoRequestDTO.getMarca());
     }

     if(produtoRequestDTO.getCategorias()==null || produtoRequestDTO.getCategorias().isEmpty()){
       response  = new ResponseModel<>(404,"Para cadastrar um produto é necessário ao menos uma categorias estar associada",data);

       return new ResponseEntity<ResponseModel<Produto>>(response,HttpStatus.NOT_FOUND);
     }

     fotos = produtoRequestDTO.getFotos()==null?  new ArrayList<>() : produtoRequestDTO.getFotos();

     for (int i = 0; i < produtoRequestDTO.getCategorias().size(); i++) {
       Long id = produtoRequestDTO.getCategorias().get(i);
       Categoria categoria  = categoriaService.get(id);
       categorias.add(categoria);
     }

     ProdutoDTO produtoDTO = new ProdutoDTO(produtoRequestDTO);
     produtoDTO.setCategorias(categorias);
     produtoDTO.setMarca(marca); 
     produtoDTO.setFotos(fotos);



     UUID id  = produtoService.create(produtoDTO);
     Produto produto = produtoService.get(id);
     data.add(produto);

     response = new ResponseModel<Produto>(201,"Sucesso",data);

     return new ResponseEntity<ResponseModel<Produto>>(response,HttpStatus.CREATED);
      
    } catch (Exception e) {
      response = new ResponseModel<Produto>(500,"Ocorreu um erro na criação do Produto",data);

      return new ResponseEntity<ResponseModel<Produto>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

  @PutMapping("/{id}")
  @ApiOperation(value = "Atualiza um produto")
  public ResponseEntity<ResponseModel<Produto>> updateProduto(@ApiParam(value = "Id do produto") @PathVariable("id") UUID id, @RequestBody ProdutoRequestDTO  produtoRequestDTO){

    List<Produto> data = new ArrayList<Produto>();
    ResponseModel<Produto> response ;
    Marca marca = null;
    List<Categoria> categorias = new ArrayList<>();
    List<FotoProduto> fotos ;
    Produto produto;

    try{

    if(!produtoService.produtoExists(id)){

      response = new ResponseModel<Produto>(404,"Produto não encontrado",data);
      return new ResponseEntity<ResponseModel<Produto>>(response,HttpStatus.NOT_FOUND);

    }

    
    if(produtoRequestDTO.getMarca()!=null){
      marca = marcaService.get(produtoRequestDTO.getMarca());
    }

    if(produtoRequestDTO.getCategorias()!=null){
      if( produtoRequestDTO.getCategorias().isEmpty()){
        response  = new ResponseModel<>(404,"Para cadastrar um produto é necessário ao menos uma categorias estar associada",data);

        return new ResponseEntity<ResponseModel<Produto>>(response,HttpStatus.NOT_FOUND);
      }

      for (int i = 0; i < produtoRequestDTO.getCategorias().size(); i++) {
        Long idCategoria = produtoRequestDTO.getCategorias().get(i);
        Categoria categoria  = categoriaService.get(idCategoria);
        categorias.add(categoria);
      }
    }

    fotos = produtoRequestDTO.getFotos()==null?  new ArrayList<>() : produtoRequestDTO.getFotos();

   

    ProdutoDTO produtoDTO = new ProdutoDTO(produtoRequestDTO);
    produtoDTO.setCategorias(categorias);
    produtoDTO.setMarca(marca); 
    produtoDTO.setFotos(fotos);

    produto  = produtoService.update(id, produtoDTO);
    data.add(produto);

    response = new ResponseModel<Produto>(200,"Sucesso",data);

    return new ResponseEntity<ResponseModel<Produto>>(response,HttpStatus.ACCEPTED);

    }catch(Exception e){
      System.err.println("Excption" + e.toString());
      response = new ResponseModel<Produto>(500,"Erro ao atualizar Produto",data);
      return new ResponseEntity<ResponseModel<Produto>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  @DeleteMapping("/{id}")
  @ApiOperation(value = "Deleta um produto")
  public ResponseEntity<ResponseModel<Produto>> deleteProduto(@ApiParam(value = "Id do produto") @PathVariable("id") UUID id){
    
    List<Produto> data = new ArrayList<Produto>();
    ResponseModel<Produto> response ;

    try {
      produtoService.delete(id);
      response = new ResponseModel<Produto>(203,"Sucesso",data);
      return new ResponseEntity<ResponseModel<Produto>>(response,HttpStatus.NON_AUTHORITATIVE_INFORMATION);

    } catch (Exception e) {
      response = new ResponseModel<Produto>(500,"Ocorreu um erro ao deletar o produto",data);
      return new ResponseEntity<ResponseModel<Produto>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }
  
  }
}
