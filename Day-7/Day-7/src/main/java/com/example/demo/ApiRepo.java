package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ApiRepo extends JpaRepository<ApiTable,Integer>{
	public List<ApiTable>findByDeptAndName(String d,String n);
	public List<ApiTable>findByDeptOrName(String d1,String n1);
	public List<ApiTable>findBySalaryIn(List<Double>sal);
	public List<ApiTable>findByNameStartingWith(String a);
	public List<ApiTable>findByNameEndingWith(String b);
	
	@Query("select u from ApiTable u")
	public List <ApiTable> getAllUsers();
	
	@Query ("select u from ApiTable u where u.name=:a")
	public List <ApiTable> getAllUserName(@Param("a") String name);
	@Modifying
	@Query("update ApiTable c set c.salary=:s where c.id=:d")
	public int getAllUserSalary(@Param ("s") double sal,@Param ("d") int id);
}
