package pe.gob.contraloria.demo.presentation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MenuResponse {

	
	@JsonProperty("codigo")
	private String code;
	
	@JsonProperty("nombre")
	private String name;
	
	@JsonProperty("secuencia")
	private long secuencia;

	public MenuResponse() {
		super();
	}
	
	public MenuResponse(String code, String name, long secuencia) {
		super();
		this.code = code;
		this.name = name;
		this.secuencia = secuencia;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(long secuencia) {
		this.secuencia = secuencia;
	}
	
	
	
}
