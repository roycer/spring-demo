package pe.gob.contraloria.demo.business.service;

import java.util.List;

import pe.gob.contraloria.demo.business.dto.MenuDto;

public interface MenuService {

	MenuDto get(String code);
	List<MenuDto> get(int limit);
	void register(String name);
	void update(String name);
	void delete(String code);

}
