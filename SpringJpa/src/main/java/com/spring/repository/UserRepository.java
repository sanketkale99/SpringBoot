package com.spring.repository;

import java.util.List;

import org.aspectj.weaver.tools.Trace;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.spring.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	//public List<User> findByCity(String city);

	//public List<User> findByNameAndCity(String name,String city);
	
//	@Query("select u from User u")
//	public List<User> getAllUser();
	
//	@Query("select u from User u where u.name=:n")
//	public List<User> getUserByName(@Param("n")String name);
	
	//native query
	
	@Query(value = "select * from User", nativeQuery = true)
	public List<User> getUsers();
	
	
	
	
	
}
