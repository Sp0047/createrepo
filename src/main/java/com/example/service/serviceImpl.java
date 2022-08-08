package com.example.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.model.Employee;
import com.example.repository.repository;


@Service
public class serviceImpl implements service{
	
	@Autowired
	public repository repo;
	
	

	@Override
	public Employee savedata(Employee emp) {
		Employee save = repo.save(emp);
		return save;
	}
	
	
	
	@Override
	public List<Employee> saveListData(List<Employee> listemp) {
		
		List<Employee> saveAll = repo.saveAll(listemp);
		
	       return saveAll;
	}
	
	

	@Override
	public List<Employee> GetAllData() {
		List<Employee> list = repo.findAll();
		return list;
	}
	
	

	@Override
	public Employee getById(int id) {
		
		Optional<Employee> findById = repo.findById(id);
		return findById.get();
	}

	@Override
	public List<Employee> getByAge(int age) {
		
		
		List<Employee> findByAgeGreaterThanEqual = repo.findByAgeGreaterThanEqual(age);
		System.out.println(findByAgeGreaterThanEqual);
		
		return  findByAgeGreaterThanEqual;
		
		
	}



	@Override
	public Employee update(Employee emp) {
		Employee save = repo.save(emp);
		return save;
	}



	@Override
	public List<Employee> updateListData(List<Employee> listemp) {
	List<Employee> saveAll = repo.saveAll(listemp);
	
		return saveAll;
	}



/*	@Override
	public Employee login(int id,String name) {
		 Employee findByIdAndFindByName = repo.findByIdAndFindByName(id,name);
	    //  for(Employee emp1:employee) {
	    	//  if(emp.getId()==emp1.getId()&&emp.getName().equals(emp1.getName())) {
	    		  
	    		  return findByIdAndFindByName;
	    
	}*/
	
	@Override
	public Employee loginCheck(String name, int id) {
		Employee employee = repo.findByNameAndId(name, id);
		return employee;
	}

	@Override
	public boolean delete(int id) {
		
		boolean existsById = repo.existsById(id);
		if(existsById)
		{
			repo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public void deleteAll() {
				
		repo.deleteAll();
		
	}



	

}
