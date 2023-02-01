package pe.gob.contraloria.demo.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import pe.gob.contraloria.demo.persistence.model.Menu;

public interface MenuRepository extends PagingAndSortingRepository<Menu, String> {

}
