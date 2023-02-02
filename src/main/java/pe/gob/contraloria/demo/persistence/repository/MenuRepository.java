package pe.gob.contraloria.demo.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import pe.gob.contraloria.demo.persistence.model.Menu;

public interface MenuRepository extends PagingAndSortingRepository<Menu, String> {

	Page<Menu> findAll(Pageable pageable);
	Menu findFirstByCode(String code);
}
