package com.example.service;
import java.util.List;
import com.example.model.Employee;

public interface service {
	
	public Employee savedata(Employee emp);
	
	public List<Employee> saveListData(List<Employee> listemp);
	
	public List<Employee> GetAllData();
	
	public Employee getById(int id);
	
	public List<Employee> getByAge(int age);
	
	
	
	public Employee update(Employee emp);
	
	public List<Employee> updateListData(List<Employee> listemp);
	
	public Employee loginCheck(String name,int id);

	public boolean delete(int id);
	public void deleteAll();
}
