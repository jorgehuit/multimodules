package com.axa.mx.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.axa.mx.persistence.entity.CatOpcionCondicion;

public interface CatOpcionCondicionRepository extends CrudRepository<CatOpcionCondicion, Long>{

	@Query(value = "SELECT coc "
			+ "FROM CatOpcionCondicion coc "
			+ "WHERE coc.descripcion = :descripcion "
			+ "AND coc.activo = 1 ")
	List<CatOpcionCondicion> getByDescripcion(
			@Param (value = "descripcion" ) String descripcion);

}
