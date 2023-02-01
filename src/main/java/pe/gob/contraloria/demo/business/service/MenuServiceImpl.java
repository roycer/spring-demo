package pe.gob.contraloria.demo.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import pe.gob.contraloria.demo.persistence.repository.MenuRepository;
import pe.gob.contraloria.demo.presentation.dto.MenuRequest;
import pe.gob.contraloria.demo.presentation.dto.MenuResponse;


@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepository repository;

	@Override
	public MenuResponse get(String code) {
		return null;
	}

	@Override
	public List<MenuResponse> get(Pageable pageable) {
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