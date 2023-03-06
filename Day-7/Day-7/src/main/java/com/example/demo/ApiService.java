package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiService {
	@Autowired
		ApiRepo repository;
	public List<ApiTable>findByDeptAndName(String d,String n){
		return repository.findByDeptAndName(d,n);
	}
	public List<ApiTable>findByDeptOrName(String d1,String n1){
		return repository.findByDeptOrName(d1,n1);
	}
	public List<ApiTable> findBySalaryIn(List<Double> sal) {
		return repository.findBySalaryIn(sal);
	}
	public List<ApiTable> findByNameStartingWith(String start) {
		return repository.findByNameStartingWith(start);
	}
	public List<ApiTable> findByNameEndingWith(String end) {
		return repository.findByNameEndingWith(end);
	}
	public List <ApiTable> getAllUsers(){
		return repository.getAllUsers();
	}
	public List <ApiTable> getAllUserName(String n){
		return repository.getAllUserName(n);
	}
	public int getAllUserSal(double sal,int id) {
		return repository.getAllUserSalary(sal, id);
	}
}
