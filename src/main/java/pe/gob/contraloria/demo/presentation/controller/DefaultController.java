package pe.gob.contraloria.demo.presentation.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import pe.gob.contraloria.demo.business.dto.MenuRequest;
import pe.gob.contraloria.demo.business.dto.MenuResponse;
import pe.gob.contraloria.demo.business.service.MenuService;
import pe.gob.contraloria.demo.presentation.exception.ModelNotFoundException;

@RestController
@RequestMapping("/defaults")
public class DefaultController {
	
	@Autowired
	private MenuService menuService;

	@GetMapping("/{id}")
	public ResponseEntity<?> show(
			@PathVariable("id") String id,
			@RequestHeader HttpHeaders headers
	) {

		MenuResponse obj = menuService.get(id);

		if (obj == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		return ResponseEntity.ok(obj);
		
	}

	@GetMapping
	public ResponseEntity<?> index(
			@RequestHeader HttpHeaders headers,
			@RequestParam(value = "limit", required = false, defaultValue = "1000") int limit
	) {

		List<MenuResponse> obj = menuService.get(limit);

		if (obj == null) {
			throw new ModelNotFoundException("No encontrado");
		}
		
		return ResponseEntity.ok(obj);
		
	}
	
	@PostMapping
	public ResponseEntity<?> store(
			@Valid @RequestBody MenuRequest menuRequest
		) 
	{
		
		MenuResponse obj = menuService.register(menuRequest);
		
		if (obj == null) {
			throw new ModelNotFoundException("No encontrado");
		}
		
		return ResponseEntity.ok(obj);
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody MenuRequest menuRequest) 
	{
		MenuResponse obj = menuService.update(menuRequest);
		
		if (obj == null) {
			throw new ModelNotFoundException("No encontrado");
		}
		
		return ResponseEntity.ok(obj);
    }
	

	@DeleteMapping("/{id}")
	public ResponseEntity<?> destroy(@PathVariable("id") String code) 
	{
		
		if (!menuService.delete(code)) {
			throw new ModelNotFoundException("No encontrado");
		}
		
		return ResponseEntity.ok("No se pudo eliminar");
    }
}