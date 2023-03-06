package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;


@RestController
public class ApiController {
	@Autowired
		ApiRepo repository;
	@Autowired
		ApiService service;
	@GetMapping("/findname/{name}/{dept}")
	public List<ApiTable>finddetails(@PathVariable String dept,@PathVariable String name){
		return service.findByDeptAndName(dept, name);
	}
	@GetMapping("/findname1/{name1}/{dept1}")
	public List<ApiTable>find(@PathVariable String dept1,@PathVariable String name1){
		return service.findByDeptOrName(dept1, name1);
	}
	@GetMapping("/getsalary")
	public List<ApiTable>findBySal(@RequestParam("salary")List<Double>sal){
		List<ApiTable>s1 = service.findBySalaryIn(sal);
		return s1;
	}
	@GetMapping("/getname2/{start}")
	public List<ApiTable>findByNameStartingWith(@PathVariable("Start")String start){
		return service.findByNameStartingWith(start);
	}
	@GetMapping("/getname3/{start}")
	public List<ApiTable>findByNameEndingWith(@PathVariable("Start")String end){
		return service.findByNameEndingWith(end);
	}
	@GetMapping("/getAllUsers")
	public List <ApiTable> getAllUsersList(){
		return service.getAllUsers();
	}
	@GetMapping("/getAllUsers/{name}")
	public List <ApiTable> getAllUserListName(@PathVariable String name){
		return service.getAllUserName(name);
	}
	@Transactional
	@PutMapping(value="/getAllUsers/{sal}/{id}")
	public String getAllUserListName(@PathVariable("sal") double sal,@PathVariable int id) {
		String res="";
		int result =service.getAllUserSal(sal, id);
		if(result>0) {
			res="Salary Updated "+result;
			System.err.println(res);
		}
		else {
			res = "Not Updated "+result;
			System.err.println(res);
		}
		return res;
	}
}
