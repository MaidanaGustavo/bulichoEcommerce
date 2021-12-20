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

import bulicho.ecommerce.bulicho.dto.CategoriaDTO;
import bulicho.ecommerce.bulicho.dto.CategoriaRequestDTO;
import bulicho.ecommerce.bulicho.entities.Categoria;
import bulicho.ecommerce.bulicho.entities.Departamento;
import bulicho.ecommerce.bulicho.models.ResponseModel;
import bulicho.ecommerce.bulicho.services.interfaces.ICategoriaService;
import bulicho.ecommerce.bulicho.services.interfaces.IDepartamentoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "Categoria ")
@RequestMapping("/api/categorias")
public class CategoriaController {
  
  @Autowired
  private ICategoriaService categoriaService;
  @Autowired
  private IDepartamentoService departamentoService;

  @GetMapping
  @ApiOperation(value = "Busca todas as categorias")
  public ResponseEntity<ResponseModel<Categoria>> listAllCategorias(){
    List<Categoria> categorias  = categoriaService.listAll();
    ResponseModel<Categoria> response = new ResponseModel<Categoria>(200,"Sucesso",categorias);

    return new ResponseEntity<ResponseModel<Categoria>>(response,HttpStatus.OK);
  }

  @GetMapping("/{id}")
  @ApiOperation(value = "Busca uma categoria pelo Id")
  public ResponseEntity<ResponseModel<Categoria>> getCategoria(@ApiParam(value = "Id da Categoria",required = true) @PathVariable("id") Long id ){
    List<Categoria> categorias = new ArrayList<Categoria>();
    ResponseModel<Categoria> response; 

    if(!categoriaService.categoriaExists(id)){
      response = new ResponseModel<Categoria>(404,"Categoria não encontrada",new ArrayList<>());
      return new ResponseEntity<ResponseModel<Categoria>>(response,HttpStatus.NOT_FOUND);
    }

    Categoria categoria  = categoriaService.get(id);
    categorias.add(categoria);
    response = new ResponseModel<Categoria>(200,"Sucesso",categorias);

    return new ResponseEntity<ResponseModel<Categoria>>(response,HttpStatus.OK);
  }



  @PostMapping
  @ApiOperation(value = "Cria uma nova Categoria")
  public ResponseEntity<ResponseModel<Categoria>> createCategoria(@RequestBody CategoriaRequestDTO categoriaRequestDTO){
    List<Categoria> categorias = new ArrayList<Categoria>();
    ResponseModel<Categoria> response; 
    HttpStatus status;
    CategoriaDTO categoriaDTO;

    if(!departamentoService.departamentoExists(categoriaRequestDTO.getIdDepartamento())){
      response = new ResponseModel<Categoria>(404,"Departamento informado não encontrado",categorias);
      return new ResponseEntity< ResponseModel<Categoria>>(response,HttpStatus.NOT_FOUND);
    }
    try{
      Departamento departamento = departamentoService.get(categoriaRequestDTO.getIdDepartamento());
      categoriaDTO = new CategoriaDTO(categoriaRequestDTO.getNome(),departamento);
      Long id = categoriaService.create(categoriaDTO);
      Categoria categoria = categoriaService.get(id);

      status = HttpStatus.CREATED;
      categorias.add(categoria);
      response = new ResponseModel<Categoria>(201,"Sucesso",categorias);

    }catch(Exception e){
      status = HttpStatus.INTERNAL_SERVER_ERROR;
      response = new ResponseModel<Categoria>(500,"Não foi possível criar a categoria",categorias);
    }

    return new ResponseEntity< ResponseModel<Categoria>>(response,status);
  }

  @PutMapping("/{id}")
  @ApiOperation(value = "Atualiza uma categoria")
  public ResponseEntity<ResponseModel<Categoria>> updateCategoria(@ApiParam(value = "Id da Categoria",required = true) @PathVariable("id") Long id, @RequestBody CategoriaRequestDTO categoriaRequestDTO){

    List<Categoria> categorias = new ArrayList<Categoria>();
    ResponseModel<Categoria> response;
    HttpStatus status;
    CategoriaDTO categoriaDTO;
    Departamento departamento = null;

    if(!categoriaService.categoriaExists(id)){
      response = new ResponseModel<Categoria>(404,"Categoria não encontrada",new ArrayList<>());
      return new ResponseEntity<ResponseModel<Categoria>>(response,HttpStatus.NOT_FOUND);
    }


    if(categoriaRequestDTO.getIdDepartamento()!=null){
      if(!departamentoService.departamentoExists(categoriaRequestDTO.getIdDepartamento())){
        response = new ResponseModel<Categoria>(404,"Departamento informado não encontrado",categorias);
        return new ResponseEntity< ResponseModel<Categoria>>(response,HttpStatus.NOT_FOUND);
      }
      
       departamento = departamentoService.get(categoriaRequestDTO.getIdDepartamento());
    }
    try{
      categoriaDTO = new CategoriaDTO(categoriaRequestDTO.getNome(),departamento);
      Categoria categoria = categoriaService.update(id, categoriaDTO);
      categorias.add(categoria);
      status = HttpStatus.CREATED;
      response = new ResponseModel<Categoria>(200,"Sucessooo",categorias);

    }catch(Exception e){
      status = HttpStatus.INTERNAL_SERVER_ERROR;
      response = new ResponseModel<Categoria>(500,"Não foi possível atualizar a categoria",categorias);
    }

    return new ResponseEntity< ResponseModel<Categoria>>(response,status);
  }

  @DeleteMapping("/{id}")
  @ApiOperation(value = "Deleta uma categoria")
  public ResponseEntity<ResponseModel<Categoria>> deleteCategoria(@ApiParam(value = "Id da categoria",required = true) @PathVariable("id") Long id){
    List<Categoria> categorias = new ArrayList<Categoria>();
    ResponseModel<Categoria> response;
    HttpStatus status;

    if(!categoriaService.categoriaExists(id)){
      response = new ResponseModel<Categoria>(404,"Categoria não encontrada",new ArrayList<>());
      return new ResponseEntity<ResponseModel<Categoria>>(response,HttpStatus.NOT_FOUND);
    }

    try{
      categoriaService.delete(id);
      response = new ResponseModel<Categoria>(203,"Sucesso",categorias);
      status = HttpStatus.NON_AUTHORITATIVE_INFORMATION;
    }catch(Exception e){
      status = HttpStatus.INTERNAL_SERVER_ERROR;
      response = new ResponseModel<Categoria>(500,"Não foi possível deletar a categoria",categorias);
    }

    return new ResponseEntity<ResponseModel<Categoria>>(response,status);
  }
}
