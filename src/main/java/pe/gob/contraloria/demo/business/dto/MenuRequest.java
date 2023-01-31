package pe.gob.contraloria.demo.business.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class MenuRequest {

    @Pattern(regexp = "^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$", message = "mensaje de error se recomienda .env")
    private String name;

    @Min(value = 1, message = "Mínimo 1")
    @Max(value = 100, message = "Máximo 100")
    @NotBlank(message = "Name is mandatory")
    private int order;
    
}
