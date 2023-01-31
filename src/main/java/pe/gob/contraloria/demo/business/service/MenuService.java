package pe.gob.contraloria.demo.business.service;

import java.util.List;

import pe.gob.contraloria.demo.business.dto.MenuRegisterDto;
import pe.gob.contraloria.demo.business.dto.MenuResponseDto;
import pe.gob.contraloria.demo.business.dto.MenuUpdateDto;

public interface MenuService {

	MenuResponseDto get(String code);
	List<MenuResponseDto> get(int limit);
	MenuResponseDto register(MenuRegisterDto menu);
	MenuResponseDto update(MenuUpdateDto menu);
	void delete(String code);

}
