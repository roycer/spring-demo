package pe.gob.contraloria.demo.presentation.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class MenuRequest {

	//ejemplo: texto
    @Pattern(regexp = "^[a-zA-Z0-9]{2,10}$", message = "Mínimo tiene que contener un carácter")
    private String name;

    @Min(value = 1, message = "Numero ingresado debe ser mayor a 1")
    @Max(value = 100, message = "Numero ingresado no debe ser mayor a 100")
    private Integer order;

	public String getName() {
		return name;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public void setName(String name) {
		this.name = name;
	}



}
