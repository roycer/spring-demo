package pe.gob.contraloria.demo.presentation.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class MenuRequest {

    @Pattern(regexp = "^[a-zA-Z0-9]{2,10}$", message = "Mínimo tiene que contener un carácter")
    private String name;

    @Min(value = 1, message = "Numero ingresado debe ser mayor a 1")
    @Max(value = 100, message = "Numero ingresado no debe ser mayor a 100")
    @NotBlank(message = "Este un campo obligatorio")
    private int order;
    
}
