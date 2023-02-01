package pe.gob.contraloria.demo.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
		return null;
	}

	@Override
	public List<MenuResponse> get(Integer nroPagina, Integer regXPagina, String ordenar) {
		
		Page<Menu> pageMenuRepository = menuRepository.findAll(PageRequest.of(nroPagina, regXPagina, Sort.by(ordenar).descending()));
		
		
		
		return null;
	}

	@Override
	public MenuResponse register(MenuRequest menu) {
		return null;
	}

	@Override
	public MenuResponse update(MenuRequest menu) {
		return null;
	}

	@Override
	public boolean delete(String code) {
		return false;
	}
	



}