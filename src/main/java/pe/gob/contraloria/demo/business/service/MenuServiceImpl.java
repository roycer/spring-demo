package pe.gob.contraloria.demo.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import pe.gob.contraloria.demo.persistence.model.Menu;
import pe.gob.contraloria.demo.persistence.repository.MenuRepository;
import pe.gob.contraloria.demo.presentation.dto.MenuRequest;
import pe.gob.contraloria.demo.presentation.dto.MenuResponse;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepository menuRepository;

	@Override
	public MenuResponse get(String code) {
		
		 Menu menu = menuRepository.findFirstByCode(code);
		
		 if(menu == null) return null;
		
		return this.convertToMenuResponse(menuRepository.findFirstByCode(code));
	}

	@Override
	public List<MenuResponse> get(Integer nroPagina, Integer regXPagina, String ordenar) {
		
		Page<Menu> menus = menuRepository.findAll(PageRequest.of(nroPagina, regXPagina, Sort.by(ordenar).descending()));
		
		Page<MenuResponse> menusdto = menus.map(this::convertToMenuResponse);
		
		return menusdto.getContent();
		
	}

	@Override
	public MenuResponse register(MenuRequest menu) {
		
		return this.convertToMenuResponse(this.menuRepository.save(this.convertToMenuEntity(menu)));
		
	}

	@Override
	public MenuResponse update(String code, MenuRequest menuRequest) {
		
		Menu menu = this.convertToMenuEntity(menuRequest);
		menu.setCode(code);
		
		return this.convertToMenuResponse(this.menuRepository.save(menu));
		
	}

	@Override
	public boolean delete(String code) {
		return false;
	}
	
	private MenuResponse convertToMenuResponse(Menu menu) {
		
		MenuResponse menuResponse = new MenuResponse();
		menuResponse.setName(menu.getName());
		return menuResponse;
	}
	
	private Menu convertToMenuEntity(MenuRequest menuRequest) {
		
		Menu menu = new Menu();
		menu.setCode("2");
		menu.setCodeAllow("1");
		menu.setCodeIntern("test");
		menu.setName(menuRequest.getName());
		menu.setOrder(menuRequest.getOrder());
		menu.setState("1");
		
		
		return menu;
		
	}



}