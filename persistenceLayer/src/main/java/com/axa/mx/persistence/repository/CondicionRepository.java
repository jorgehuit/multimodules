package com.axa.mx.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.axa.mx.persistence.entity.Condicion;

public interface CondicionRepository extends CrudRepository<Condicion, Long> {

	@Query(value = "SELECT c "
			+ "FROM Condicion c "
			+ "WHERE c.idGenerado LIKE CONCAT('%',:tipo,'%') ", 
			nativeQuery = false)
	List<Condicion> getCondicionByIdGenerado(@Param(value = "tipo") String tipo);
	
}
