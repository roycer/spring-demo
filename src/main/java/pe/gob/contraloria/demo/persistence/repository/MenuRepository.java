package pe.gob.contraloria.demo.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import pe.gob.contraloria.demo.persistence.model.Menu;

public interface MenuRepository extends PagingAndSortingRepository<Menu, String> {

	Page<Menu> findByDeletedIsNull(Pageable pageable);
	Menu findFirstByCodeAndDeletedIsNull(String code);
	Menu findByCodeAndDeletedIsNull(String code);
}
