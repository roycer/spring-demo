package pe.gob.contraloria.demo.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.contraloria.demo.business.dto.MenuDto;
import pe.gob.contraloria.demo.persistence.repository.MenuRepository;


@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepository repository;
	
	@Override
	public MenuDto get(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MenuDto> get(int limit) {
		return null;
	}

	@Override
	public void register(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String code) {
		// TODO Auto-generated method stub
		
	}


}