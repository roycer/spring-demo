package pe.gob.contraloria.demo.business.service;

import java.util.List;

import pe.gob.contraloria.demo.business.dto.MenuRequest;
import pe.gob.contraloria.demo.business.dto.MenuResponse;

public interface MenuService {

	MenuResponse get(String code);
	List<MenuResponse> get(int limit);
	MenuResponse register(MenuRequest menu);
	MenuResponse update(MenuRequest menu);
	boolean delete(String code);

}
