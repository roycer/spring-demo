package pe.gob.contraloria.demo.presentation.controller;

import java.util.List;


import javax.validation.constraints.Pattern;

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
import pe.gob.contraloria.demo.presentation.exception.ControllerError;
import pe.gob.contraloria.demo.presentation.exception.ControllerRuntimeException;
import pe.gob.contraloria.demo.util.ResponseApi;
@RestController
@RequestMapping("/menus")
@RequiredArgsConstructor
@Validated
public class MenuController {
	
	@Autowired
	private MenuService menuService;

	@GetMapping("/{codigo}")
	public ResponseEntity<ResponseApi<MenuResponse>> show(
			@Pattern(regexp = "^[a-zA-Z0-9]{1,7}$", message = "Mínimo tiene que contener un carácter") @PathVariable(value = "codigo", required = true) String code, 
			@RequestHeader HttpHeaders headers) {
		
		MenuResponse obj = menuService.get(code);
		
		if (obj == null) return new ResponseEntity<>(new ResponseApi<>(obj,"No se encontraron registros"), HttpStatus.NOT_FOUND);	
		
		return new ResponseEntity<>(new ResponseApi<>(obj,"La consulta se realizo correctamente"), HttpStatus.OK);	
		
	}

	@GetMapping
	public ResponseEntity<ResponseApi<List<MenuResponse>>> index(
			@RequestParam(value = "nroPagina", required = true) Integer nroPagina, 
			@RequestParam(value = "regXPagina", required = true) Integer regXPagina, 
			@RequestParam(value = "ordenar", required = true) String ordenar, 
			@RequestHeader HttpHeaders headers) {
		
		List<MenuResponse> objs = menuService.get(nroPagina, regXPagina, ordenar);
		
		if (objs == null) return new ResponseEntity<>(new ResponseApi<>(objs,"No se encontraron registros"), HttpStatus.NOT_FOUND);	
		
		return new ResponseEntity<>(new ResponseApi<>(objs,"La petición se realizó correctamente") , HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<ResponseApi<MenuResponse>> store(
			@RequestBody MenuRequest menuRequest, 
			@RequestHeader HttpHeaders headers) {
		
		MenuResponse obj = menuService.register(menuRequest);
		
		if (obj == null) return new ResponseEntity<>(new ResponseApi<>(obj,"La petición no se pudo realizar") , HttpStatus.NOT_ACCEPTABLE);
		
		return new ResponseEntity<>(new ResponseApi<>(obj,"La actualización se realizó correctamente") , HttpStatus.CREATED);
		
    }
	
	@PutMapping("/{codigo}")
	public ResponseEntity<ResponseApi<MenuResponse>> update(
			@Pattern(regexp = "^[a-zA-Z0-9]{1,7}$", message = "Mínimo tiene que contener un carácter") @PathVariable(value = "codigo", required = true) String code, 
			@RequestBody MenuRequest menuRequest, 
			@RequestHeader HttpHeaders headers) {
		
		MenuResponse obj = menuService.update(menuRequest);
		
		if (obj == null) new ResponseEntity<>(new ResponseApi<>(obj,"La petición no se pudo realizar"), HttpStatus.NOT_ACCEPTABLE);	
		
		return new ResponseEntity<>(new ResponseApi<>(obj,"La actualización se realizó correctamente"), HttpStatus.OK);	
		
    }
	

	@DeleteMapping("/{codigo}")
	public ResponseEntity<ResponseApi<String>> destroy(
			@Pattern(regexp = "^[a-zA-Z0-9]{1,7}$", message = "Mínimo tiene que contener un carácter") @PathVariable(value = "codigo", required = true) String code, 
			@RequestHeader HttpHeaders headers) {
		
		if (!menuService.delete(code)) new ResponseEntity<>(new ResponseApi<>(null,"Error en la Eliminación"), HttpStatus.NOT_ACCEPTABLE); 
		
		return new ResponseEntity<>(new ResponseApi<>(null,"Se ha eliminado correctamente"), HttpStatus.OK);
		
    }
	
}