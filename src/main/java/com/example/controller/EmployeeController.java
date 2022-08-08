package com.example.controller;

import java.util.List;

import org.springframework.aop.target.EmptyTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.service;


@RestController
public class EmployeeController {
	@Autowired
	public service service;
	

	@GetMapping(value ="/save" ,consumes = {"application/json"} ,produces = {"application/json"})
	public ResponseEntity<Employee> savedata(@RequestBody Employee emp) {
		Employee savadata = service.savedata(emp);
								return new ResponseEntity<Employee>(savadata,HttpStatus.OK);
	}
	
	
	@GetMapping(value ="/savelist" ,consumes = {"application/json"} ,produces = {"application/json"})
	public ResponseEntity <List<Employee>> saveList(@RequestBody List<Employee> empList) {
		 List<Employee> saveListData = service.saveListData(empList);
			return new ResponseEntity <List<Employee>>(saveListData,HttpStatus.OK);
	}
	
	
	
	@GetMapping(value ="/data",produces = {"application/json"})
	public ResponseEntity<List<Employee>> getdata() {
        List<Employee> list = service.GetAllData();
		return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
	}
	
	@PostMapping(value = "/getdata/{id}",produces = {"application/json"})
	public ResponseEntity<Employee> DataById(@PathVariable int id){
		Employee byId = service.getById(id);
		
		return new ResponseEntity<Employee>(byId,HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/getage/{age}",produces = {"application/json"})
	public ResponseEntity <List<Employee>> DataByage(@PathVariable int age){
		List<Employee> byAge = service.getByAge(age);
		
		return new ResponseEntity<List<Employee>>(byAge,HttpStatus.OK);
	
}
	@GetMapping(value ="/update" ,consumes = {"application/json"} ,produces = {"application/json"})
	public ResponseEntity<Employee> updatedata(@RequestBody Employee emp) {
		Employee update = service.update(emp);
								return new ResponseEntity<Employee>(update,HttpStatus.CREATED);
	}
	
	
	
	@GetMapping(value ="/updatelist" ,consumes = {"application/json"} ,produces = {"application/json"})
	public ResponseEntity <List<Employee>> updateList(@RequestBody List<Employee> empList) {
		List<Employee> updateListData = service.updateListData(empList);
			return new ResponseEntity <List<Employee>>(updateListData,HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/login",consumes = "application/json")
	public ResponseEntity<String> loginCheck(@RequestBody Employee employee)
	{
		Employee employee1 = service.loginCheck(employee.getName(), employee.getId());
		
		if(employee1 != null)
		{
			return new ResponseEntity<String>("successful login",HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("login failed please check Id or Name",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping(value = "/deleteById/{id}")
	public ResponseEntity<String> delete(@PathVariable int id)
	{
		boolean flag = service.delete(id);
		
		if(flag)
		{
			return new ResponseEntity<String>("Data Deleted for Id : "+id,HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Data Can not delete because id is not matching",HttpStatus.BAD_REQUEST);

	}
	
	@GetMapping("/deleteAll")
	public ResponseEntity<String> deleteAll()
	{
		service.deleteAll();
		
		return new ResponseEntity<String>("All Employees Data Deleted Successfully",HttpStatus.OK);
	}
	
}
