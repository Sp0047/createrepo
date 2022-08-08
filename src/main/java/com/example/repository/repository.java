package com.example.repository;


import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Employee;


@Repository
public interface repository extends JpaRepository<Employee, Serializable>{

     public List<Employee>   findByAgeGreaterThanEqual(int age);
	 
     public Employee findByNameAndId(String name,int id);


}
