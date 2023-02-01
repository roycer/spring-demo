package pe.gob.contraloria.demo.presentation.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pe.gob.contraloria.demo.business.service.MenuService;
import pe.gob.contraloria.demo.presentation.dto.MenuRequest;
import pe.gob.contraloria.demo.presentation.dto.MenuResponse;
import pe.gob.contraloria.demo.presentation.exception.ModelNotFoundException;

@RestController
@RequestMapping("/menus")
@RequiredArgsConstructor
@Validated
public class MenuController {
	
	@Autowired
	private MenuService menuService;

	@GetMapping("/{id}")
	public ResponseEntity<MenuResponse> show(@Pattern(regexp = "^[a-zA-Z0-9]{1,7}$", message = "Mínimo tiene que contener un carácter") @PathVariable(value = "id", required = true) String id, @RequestHeader HttpHeaders headers){
		MenuResponse obj = menuService.get(id);
		if (obj == null) 
			throw new ModelNotFoundException("Id no encontrado " + id);
		return new ResponseEntity<>(obj, HttpStatus.OK);		
	}

	@GetMapping
	public ResponseEntity<List<MenuResponse>> index(@RequestParam(value = "nroPagina", required = true) Integer nroPagina, @RequestParam(value = "regXPagina", required = true) Integer regXPagina, @RequestParam(value = "ordenar", required = true) String ordenar, @RequestHeader HttpHeaders headers){
		List<MenuResponse> objs = menuService.get(PageRequest.of(nroPagina, regXPagina, Sort.by(ordenar).descending()));
		if (objs == null)
			throw new ModelNotFoundException("Error en la lectura");
		return new ResponseEntity<>(objs, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<MenuResponse> store(@RequestBody MenuRequest menuRequest, @RequestHeader HttpHeaders headers){
		MenuResponse obj = menuService.register(menuRequest);
		if (obj == null) 
			throw new ModelNotFoundException("Error en la creación");
		return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<MenuResponse> update(@RequestBody MenuRequest menuRequest, @RequestHeader HttpHeaders headers){
		MenuResponse obj = menuService.update(menuRequest);
		if (obj == null) 
			throw new ModelNotFoundException("Error en la Actualización");
		return new ResponseEntity<>(obj, HttpStatus.OK);
    }
	

	@DeleteMapping("/{id}")
	public ResponseEntity<String> destroy(@PathVariable("id") String code, @RequestHeader HttpHeaders headers){
		if (!menuService.delete(code)) 
			throw new ModelNotFoundException("Error en la Eliminación");
		return new ResponseEntity<>("Se ha eliminado correctamente", HttpStatus.OK);
    }
	
}