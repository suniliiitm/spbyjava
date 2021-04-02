package com.testcrud.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.testcrud.app.model.Employee;
import com.testcrud.app.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	 
	
	
	@Override
	public void saveEmployee(Employee employee) {
		
		employeeRepository.save(employee);
		
		
	}

	@Override
	public void deletebyEmployeeId(long id) {
		this.employeeRepository.deleteById(id);
		
	}

	
	
	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();

	}
	
//Override and implement "getEmployeeById()" method in EmployeeServiceImpl class like:
	
	@Override
	public Employee getEmployeeById(long id) {
							
		Optional<Employee>opt=employeeRepository.findById(id);
		Employee emp=null;
		if(opt.isPresent()) {
			
			 emp =opt.get();
		}else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		
		return emp;
	}

	
	
	
}
