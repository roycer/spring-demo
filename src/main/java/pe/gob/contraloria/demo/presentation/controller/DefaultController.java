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

import pe.gob.contraloria.demo.business.dto.MenuDto;
import pe.gob.contraloria.demo.business.service.MenuService;
import pe.gob.contraloria.demo.persistence.model.Menu;
import pe.gob.contraloria.demo.presentation.exception.ModelNotFoundException;
import pe.gob.contraloria.demo.util.ResponseApi;

@RestController
@RequestMapping("/defaults")
public class DefaultController {
	
	@Autowired
	private MenuService menuService;

	@GetMapping("/{id}")
	public ResponseEntity<MenuDto> show(
			@PathVariable("id") String id,
			@RequestHeader HttpHeaders headers
	) {

		MenuDto obj = menuService.get(id);

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

		List<MenuDto> obj = menuService.get(limit);

		if (obj == null) {
			throw new ModelNotFoundException("No encontrado");
		}
		
		return ResponseEntity.ok(obj);
		
	}
	
//	@PostMapping
//	public ResponseEntity<ResponseApi<Menu>> post(@Valid @RequestBody Menu body) 
//	{
//    	ResponseApi response = new ResponseApi();
//    	response.setStatusCode(HttpStatus.CREATED.value());
//    	response.setStatus("Ok");
//    	menuService.register(body);
//    	
//    	return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }
//	
//	@PutMapping
//	public ResponseEntity<ResponseApi<Menu>> put(@Valid @RequestBody Menu body) 
//	{
//    	ResponseApi response = new ResponseApi();
//    	response.setStatusCode(HttpStatus.OK.value());
//    	response.setStatus("Ok");
//    	menuService.update(body);
//    	
//    	return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//	
//
//	@DeleteMapping("/{id}")
//	public ResponseEntity<ResponseApi<Menu>> delete(@PathVariable("id") Integer id) 
//	{
//
//    	ResponseApi response = new ResponseApi();
//    	response.setStatusCode(HttpStatus.OK.value());
//    	response.setStatus("Ok");
//    	//menuService.delete(id);
//    	
//    	return new ResponseEntity<>(response, HttpStatus.OK);
//    }
	
//	@GetMapping
//	public ResponseEntity<ResponseApi<Menu>> all() {
//		
//		ResponseApi<Menu> response = new ResponseApi<Menu>();//en el contructor
//		response.setData(menuService.list());
//		response.setStatus("ok");
//		response.setStatusCode(200);
//		
//		return new ResponseEntity<>(response, HttpStatus.OK);
//	}
//	
//	@PostMapping
//	public ResponseEntity<ResponseApi<Menu>> post(@Valid @RequestBody Menu body) 
//	{
//    	ResponseApi response = new ResponseApi();
//    	response.setStatusCode(HttpStatus.CREATED.value());
//    	response.setStatus("Ok");
//    	menuService.register(body);
//    	
//    	return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }
//	
//	@PutMapping("/{id}")
//	public ResponseEntity<ResponseApi<Menu>> put(@PathVariable("id") String id,@Valid @RequestBody Menu body) 
//	{
//    	ResponseApi response = new ResponseApi();
//    	response.setStatusCode(HttpStatus.OK.value());
//    	response.setStatus("Ok");
//    	menuService.update(body);
//    	
//    	return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//	
//
//	@DeleteMapping("/{id}")
//	public ResponseEntity<ResponseApi<Menu>> delete(@PathVariable("id") String id) 
//	{
//
//    	ResponseApi response = new ResponseApi();
//    	response.setStatusCode(HttpStatus.OK.value());
//    	response.setStatus("Ok");
//    	
//    	menuService.delete(id);
//    	
//    	return new ResponseEntity<>(response, HttpStatus.OK);
//    }
}
