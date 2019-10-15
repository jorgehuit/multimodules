package com.axa.mx.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.axa.mx.entity.UserExa;

public interface UserExaRepository extends CrudRepository<UserExa, Long> {
	public UserExa findByAp(String ap);
	
	@Query(value = "SELECT u "
			+ "FROM UserExa u "
			+ "WHERE u.ap = :ap "
			+ "AND u.username = :username "
			+ "AND u.address = :address ", nativeQuery = false)
	public UserExa findByApUsernameAddress(
			@Param(value = "ap") String ap, 
			@Param(value = "username") String username, 
			@Param(value = "address") String address);
}
