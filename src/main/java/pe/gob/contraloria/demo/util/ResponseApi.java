package pe.gob.contraloria.demo.util;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseApi <T>{
	
	@JsonProperty("data")
	private T data = null;
		
	@JsonProperty("message")
	private String message;
		
	public ResponseApi() {
		super();
	}

	public ResponseApi(T data, String message) {
		super();
		this.data = data;
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
