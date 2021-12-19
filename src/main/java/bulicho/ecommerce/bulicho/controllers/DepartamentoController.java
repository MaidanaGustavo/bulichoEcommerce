package bulicho.ecommerce.bulicho.controllers;

import java.util.ArrayList;
import java.util.List;

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

import bulicho.ecommerce.bulicho.dto.DepartamentoDTO;
import bulicho.ecommerce.bulicho.entities.Departamento;
import bulicho.ecommerce.bulicho.models.ResponseModel;
import bulicho.ecommerce.bulicho.services.impl.DepartamentoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Departamento")
@RequestMapping("/api/departamentos")
public class DepartamentoController {
  
  @Autowired
  private DepartamentoService departamentoService;

  @ApiOperation(value = "Lista todos os Departamentos")
  @ApiResponses(value={
    @ApiResponse(code=200,message = "Ok")
  })
  @GetMapping
  public ResponseEntity<ResponseModel<Departamento>> listAll(){

    List<Departamento> departamentos = departamentoService.listAll();
    ResponseModel<Departamento> response  = new ResponseModel<>(200,"Sucesso",departamentos);
    
    return new ResponseEntity<ResponseModel<Departamento>>(response,HttpStatus.OK);
  }

  @ApiOperation(value = "Busca um departamento por id")
  @GetMapping("/{id}")
  public ResponseEntity<ResponseModel<Departamento>> getDepartamento(@ApiParam(value = "Id Departamento",required = true) @PathVariable("id") Long id){
    
   Departamento departamento = departamentoService.getDepartamento(id);
   ResponseModel<Departamento> response;
   List<Departamento> data = new ArrayList<>();
   if(departamento==null){
     response = new ResponseModel<>(404,"Departamento não encontrado",data);
     return new ResponseEntity<ResponseModel<Departamento>>(response,HttpStatus.NOT_FOUND);
   }
    data.add(departamento);

    response = new ResponseModel<Departamento>(200,"Sucesso",data);

    return new ResponseEntity<ResponseModel<Departamento>>(response,HttpStatus.OK);
          
  }

  @ApiOperation(value = "Cria um Departamento")
  @PostMapping
  public ResponseEntity<ResponseModel<Departamento>> createDepartamento( @RequestBody DepartamentoDTO departamentoDTO){
    ResponseModel<Departamento> response;
    List<Departamento> data = new ArrayList<>();
    HttpStatus status;

    try {
      Long id = departamentoService.createDepartamento(departamentoDTO);
      Departamento departamentoCreated = departamentoService.getDepartamento(id);
      data.add(departamentoCreated);
      response = new ResponseModel<Departamento>(201,"Sucesso",data);
      status = HttpStatus.CREATED;
    } catch (Exception e) {
      response = new ResponseModel<Departamento>(500,"Ocorreu um erro na criação do Departamento",data);
      status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    return new ResponseEntity<ResponseModel<Departamento>>(response,status);
  }

  @ApiOperation(value = "Atualiza um Departamento")
  @PutMapping("/{id}")
  public ResponseEntity<ResponseModel<Departamento>> updateDepartamento(@ApiParam(value = "Id Departamento",required = true) @PathVariable Long id, @RequestBody DepartamentoDTO departamentoDTO){
    ResponseModel<Departamento> response;
    List<Departamento> data = new ArrayList<>();

    if(!departamentoService.departamentoExists(id)) 
    return new ResponseEntity<ResponseModel<Departamento>>(new ResponseModel<Departamento>(404,"Departamento não encontrado",new ArrayList<>()),HttpStatus.NOT_FOUND);

    Departamento departamentoUpdated  = departamentoService.updateDepartamento(id, departamentoDTO);
    data.add(departamentoUpdated);
    response =  new ResponseModel<Departamento>(200,"Sucesso",data);

    return new ResponseEntity<ResponseModel<Departamento>>(response,HttpStatus.OK);
  }

  @ApiOperation(value = "Deleta um departamento")
  @DeleteMapping("{id}")
  public ResponseEntity<ResponseModel<Departamento>> deleteDepartamento(@ApiParam(value = "Id Departamento",required = true) @PathVariable Long id){
    if(!departamentoService.departamentoExists(id)) 
    return new ResponseEntity<ResponseModel<Departamento>>(new ResponseModel<Departamento>(404,"Departamento não encontrado",new ArrayList<>()),HttpStatus.NOT_FOUND);
    departamentoService.deleteDepartamento(id);
    ResponseModel<Departamento> response = new ResponseModel<Departamento>(203,"Sucesso",new ArrayList<>());
    
    return new ResponseEntity<ResponseModel<Departamento>>(response,HttpStatus.NON_AUTHORITATIVE_INFORMATION);
  }
}
