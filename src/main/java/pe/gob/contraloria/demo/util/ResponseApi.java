package pe.gob.contraloria.demo.util;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseApi <T>{
	
	@JsonProperty("data")
	private List<T> data = null;
		
	@JsonProperty("status")//no va
	private String status;
		
	@JsonProperty("statusCode") //no va
	private Integer statusCode;

	public ResponseApi() {
		super();
	}
	
	public ResponseApi(List<T> data, String status, Integer statusCode) {
		super();
		this.data = data;
		this.status = status;
		this.statusCode = statusCode;
	}

	public List<T> getData() {
		return data;
	}
	
	public void setData(List<T> data) {
		this.data = data;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Integer getStatusCode() {
		return statusCode;
	}
	
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	  
	  
}
