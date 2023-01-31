package pe.gob.contraloria.demo.business.service;

import java.util.List;

import pe.gob.contraloria.demo.presentation.dto.MenuRequest;
import pe.gob.contraloria.demo.presentation.dto.MenuResponse;

public interface MenuService {

	MenuResponse get(String code);
	List<MenuResponse> get(int limit);
	MenuResponse register(MenuRequest menu);
	MenuResponse update(MenuRequest menu);
	boolean delete(String code);

}
