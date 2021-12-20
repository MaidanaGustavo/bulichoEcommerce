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

import bulicho.ecommerce.bulicho.dto.MarcaDTO;
import bulicho.ecommerce.bulicho.entities.Marca;
import bulicho.ecommerce.bulicho.models.ResponseModel;
import bulicho.ecommerce.bulicho.services.interfaces.IMarcaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/marcas")
@Api(value ="Marca")
public class MarcaController {
  @Autowired
  private IMarcaService marcaService;

  @GetMapping
  @ApiOperation(value = "Busca todas as marcas")
  public ResponseEntity<ResponseModel<Marca>> listAllMarcas(){
    List<Marca> marcas = marcaService.listAll();
    ResponseModel<Marca> response = new ResponseModel<Marca>(200,"Sucesso",marcas);

    return new ResponseEntity<ResponseModel<Marca>>(response,HttpStatus.OK);
  }

  @GetMapping("/{id}")
  @ApiOperation(value = "Busca uma marca pelo Id")
  public ResponseEntity<ResponseModel<Marca>> getCategoria(@ApiParam(value = "Id da Marca",required = true) @PathVariable("id") UUID id ){
   
    List<Marca> data = new ArrayList<Marca>();
    ResponseModel<Marca> response; 

    if(!marcaService.marcaExists(id)){
      response = new ResponseModel<Marca>(404,"Categoria não encontrada",new ArrayList<>());
      return new ResponseEntity<ResponseModel<Marca>>(response,HttpStatus.NOT_FOUND);
    }

    Marca marca  = marcaService.get(id);
    data.add(marca);
    response = new ResponseModel<Marca>(200,"Sucesso",data);

    return new ResponseEntity<ResponseModel<Marca>>(response,HttpStatus.OK);
  }
  
  @ApiOperation(value = "Cria uma Marca")
  @PostMapping
  public ResponseEntity<ResponseModel<Marca>> createMarca( @RequestBody MarcaDTO MarcaDTO){
    ResponseModel<Marca> response;
    List<Marca> data = new ArrayList<>();
    HttpStatus status;

    try {
      UUID id = marcaService.create(MarcaDTO);
      Marca MarcaCreated = marcaService.get(id);
      data.add(MarcaCreated);
      response = new ResponseModel<Marca>(201,"Sucesso",data);
      status = HttpStatus.CREATED;
    } catch (Exception e) {
      response = new ResponseModel<Marca>(500,"Ocorreu um erro na criação do Marca",data);
      status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    return new ResponseEntity<ResponseModel<Marca>>(response,status);
  }

  @ApiOperation(value = "Atualiza uma Marca")
  @PutMapping("/{id}")
  public ResponseEntity<ResponseModel<Marca>> updateMarca(@ApiParam(value = "Id Marca",required = true) @PathVariable UUID id, @RequestBody MarcaDTO MarcaDTO){
    ResponseModel<Marca> response;
    List<Marca> data = new ArrayList<>();

    if(!marcaService.marcaExists(id)) 
    return new ResponseEntity<ResponseModel<Marca>>(new ResponseModel<Marca>(404,"Marca não encontrado",new ArrayList<>()),HttpStatus.NOT_FOUND);

    Marca MarcaUpdated  = marcaService.update(id, MarcaDTO);
    data.add(MarcaUpdated);
    response =  new ResponseModel<Marca>(200,"Sucesso",data);

    return new ResponseEntity<ResponseModel<Marca>>(response,HttpStatus.OK);
  }

  @ApiOperation(value = "Deleta uma Marca")
  @DeleteMapping("{id}")
  public ResponseEntity<ResponseModel<Marca>> deleteMarca(@ApiParam(value = "Id Marca",required = true) @PathVariable UUID id){
    if(!marcaService.marcaExists(id)) 
    return new ResponseEntity<ResponseModel<Marca>>(new ResponseModel<Marca>(404,"Marca não encontrado",new ArrayList<>()),HttpStatus.NOT_FOUND);
    marcaService.delete(id);
    ResponseModel<Marca> response = new ResponseModel<Marca>(203,"Sucesso",new ArrayList<>());
    
    return new ResponseEntity<ResponseModel<Marca>>(response,HttpStatus.NON_AUTHORITATIVE_INFORMATION);
  }
  
}
