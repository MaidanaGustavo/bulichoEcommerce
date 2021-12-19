package bulicho.ecommerce.bulicho.models;

import java.util.List;

public class ResponseModel<T> {
  
  private Integer status;
  private String mensagem;
  private List<T> data;

  public ResponseModel(){}

  public ResponseModel(Integer status,String mensagem,List<T> data){
    this.status = status;
    this.mensagem = mensagem;
    this.data  = data;
  }
  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getMensagem() {
    return this.mensagem;
  }

  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }

  public List<T> getData() {
    return this.data;
  }

  public void setData(List<T> data) {
    this.data = data;
  }

}
