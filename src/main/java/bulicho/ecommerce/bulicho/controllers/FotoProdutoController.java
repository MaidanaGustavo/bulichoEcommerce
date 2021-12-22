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

import bulicho.ecommerce.bulicho.dto.FotoProdutoDTO;
import bulicho.ecommerce.bulicho.dto.FotoProdutoRequestDTO;
import bulicho.ecommerce.bulicho.dto.FotoProdutoResponseByProdutoDTO;
import bulicho.ecommerce.bulicho.entities.FotoProduto;
import bulicho.ecommerce.bulicho.entities.Produto;
import bulicho.ecommerce.bulicho.models.ResponseModel;
import bulicho.ecommerce.bulicho.services.interfaces.IFotoProdutoService;
import bulicho.ecommerce.bulicho.services.interfaces.IProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/fotosproduto")
@Api(value = "Foto Produto")
public class FotoProdutoController {

  @Autowired
  private IFotoProdutoService fotoProdutoService;
  @Autowired
  private IProdutoService produtoService;

  @GetMapping
  @ApiOperation(value = "Busca todas as fotos")
  public ResponseEntity<ResponseModel<FotoProduto>> listAllFotosProduto(){
    List<FotoProduto> data = fotoProdutoService.listAll();
    ResponseModel<FotoProduto> response = new ResponseModel<FotoProduto>(200,"Sucesso",data);

    return new ResponseEntity<ResponseModel<FotoProduto>>(response,HttpStatus.OK);
  } 
  

  @GetMapping("/{id}")
  @ApiOperation(value = "Busca uma foto pelo Id")
  public ResponseEntity<ResponseModel<FotoProduto>> getFotoProduto(@ApiParam(value = "Id da foto",required = true) @PathVariable("id") UUID id ){
    List<FotoProduto> data = new ArrayList<FotoProduto>();
    ResponseModel<FotoProduto> response; 

   try {
     
    if(!fotoProdutoService.fotoProdutoExists(id)){
      response = new ResponseModel<FotoProduto>(404,"Foto  não encontrada",new ArrayList<>());
      return new ResponseEntity<ResponseModel<FotoProduto>>(response,HttpStatus.NOT_FOUND);
    }

    FotoProduto fotoProduto  = fotoProdutoService.get(id);
    data.add(fotoProduto);
    
    response = new ResponseModel<FotoProduto>(200,"Sucesso",data);
    return new ResponseEntity<ResponseModel<FotoProduto>>(response,HttpStatus.OK);

   
   } catch (Exception e) {
     System.err.println(e.getMessage());
    response = new ResponseModel<FotoProduto>(500,"Erro",data);
    return new ResponseEntity<ResponseModel<FotoProduto>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
   }
  }

  @PostMapping
  @ApiOperation(value = "Cria uma nova foto")
  public ResponseEntity<ResponseModel<FotoProduto>> createFotoProduto(@RequestBody FotoProdutoRequestDTO fotoProdutoRequestDTO){
    List<FotoProduto> data = new ArrayList<FotoProduto>();
    ResponseModel<FotoProduto> response; 

    try {
      if(!produtoService.produtoExists(fotoProdutoRequestDTO.getIdProduto())){

        response = new ResponseModel<FotoProduto>(404,"Produto informado não encontrado",data);
        return new ResponseEntity< ResponseModel<FotoProduto>>(response,HttpStatus.NOT_FOUND);
      }
  
      Produto produto = produtoService.get(fotoProdutoRequestDTO.getIdProduto());
      FotoProdutoDTO fotoProdutoDTO = new FotoProdutoDTO(fotoProdutoRequestDTO.getCaminho(),produto);
  
      UUID id = fotoProdutoService.create(fotoProdutoDTO);
      FotoProduto fotoProduto = fotoProdutoService.get(id);
      data.add(fotoProduto);
      response = new ResponseModel<FotoProduto>(201,"Sucesso",data);
  
      return new ResponseEntity<ResponseModel<FotoProduto>>(response,HttpStatus.CREATED);
    } catch (Exception e) {

      response = new ResponseModel<FotoProduto>(500,"Não foi possível criar a foto",data);

      return new ResponseEntity<ResponseModel<FotoProduto>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/{id}")
  @ApiOperation(value = "Atualiza uma foto")
  public ResponseEntity<ResponseModel<FotoProduto>> updateFotoProduto(@ApiParam(value = "Id da foto",required = true) @PathVariable("id") UUID id, @RequestBody FotoProdutoRequestDTO fotoProdutoRequestDTO ){

    List<FotoProduto> data = new ArrayList<FotoProduto>();
    ResponseModel<FotoProduto> response; 
    Produto produto = null;

    try {

      if(!fotoProdutoService.fotoProdutoExists(id)){
        response = new ResponseModel<FotoProduto>(404,"Foto  não encontrada",new ArrayList<>());
        return new ResponseEntity<ResponseModel<FotoProduto>>(response,HttpStatus.NOT_FOUND);
      }


      if(fotoProdutoRequestDTO.getIdProduto()!=null){
        if(!produtoService.produtoExists(fotoProdutoRequestDTO.getIdProduto())){
  
          response = new ResponseModel<FotoProduto>(404,"Produto informado não encontrado",data);
          return new ResponseEntity< ResponseModel<FotoProduto>>(response,HttpStatus.NOT_FOUND);
        }
    
         produto = produtoService.get(fotoProdutoRequestDTO.getIdProduto());
      }
      
      FotoProdutoDTO fotoProdutoDTO = new FotoProdutoDTO(fotoProdutoRequestDTO.getCaminho(),produto);
      FotoProduto  fotoProduto = fotoProdutoService.update(id, fotoProdutoDTO);
      data.add(fotoProduto);
  
      response = new ResponseModel<FotoProduto>(200,"Sucesso",data);
      return new ResponseEntity<ResponseModel<FotoProduto>>(response,HttpStatus.OK);
    } catch (Exception e) {
      response = new ResponseModel<FotoProduto>(500,"Não foi possível atualizar a Foto",data);

      return new ResponseEntity<ResponseModel<FotoProduto>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

  @DeleteMapping("/{id}")
  @ApiOperation(value = "Deleta uma Foto")
  public ResponseEntity<ResponseModel<FotoProduto>> deleteCategoria(@ApiParam(value = "Id da Foto",required = true) @PathVariable("id") UUID id){
    List<FotoProduto> data = new ArrayList<FotoProduto>();
    ResponseModel<FotoProduto> response;
    HttpStatus status;

    if(!fotoProdutoService.fotoProdutoExists(id)){
      response = new ResponseModel<FotoProduto>(404,"Foto não encontrada",new ArrayList<>());
      return new ResponseEntity<ResponseModel<FotoProduto>>(response,HttpStatus.NOT_FOUND);
    }

    try{
      fotoProdutoService.delete(id);
      response = new ResponseModel<FotoProduto>(203,"Sucesso",data);
      status = HttpStatus.NON_AUTHORITATIVE_INFORMATION;
    }catch(Exception e){
      status = HttpStatus.INTERNAL_SERVER_ERROR;
      response = new ResponseModel<FotoProduto>(500,"Não foi possível deletar a categoria",data);
    }

    return new ResponseEntity<ResponseModel<FotoProduto>>(response,status);
  }

  @GetMapping("/produto/{id}")
  @ApiOperation(value = "Busca todas as fotos de um produto")
  public ResponseEntity<ResponseModel<FotoProdutoResponseByProdutoDTO>> findByProduto(@ApiParam(value = "Id do Produto",required = true) @PathVariable("id") UUID id){

    List<FotoProdutoResponseByProdutoDTO> data = new ArrayList<FotoProdutoResponseByProdutoDTO>();
    ResponseModel<FotoProdutoResponseByProdutoDTO> response;

    if(!produtoService.produtoExists(id)){
  
      response = new ResponseModel<FotoProdutoResponseByProdutoDTO>(404,"Produto informado não encontrado",data);
      return new ResponseEntity< ResponseModel<FotoProdutoResponseByProdutoDTO>>(response,HttpStatus.NOT_FOUND);
    }
     Produto produto = produtoService.get(id);
     List<FotoProduto> fotosProduto = fotoProdutoService.findByProduto(produto);

     for (int i = 0; i < fotosProduto.size(); i++) {
       data.add(new FotoProdutoResponseByProdutoDTO(fotosProduto.get(i)));
     }
     response = new ResponseModel<FotoProdutoResponseByProdutoDTO>(200,"Sucesso",data);

    return new ResponseEntity<ResponseModel<FotoProdutoResponseByProdutoDTO>>(response,HttpStatus.OK);
  }

}
