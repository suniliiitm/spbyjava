package com.testcrud.app.service;

import java.util.List;



import com.testcrud.app.model.Employee;



public interface EmployeeService {
	
				void saveEmployee(Employee employee);
						
					void deletebyEmployeeId(long id);
					
					
					Employee getEmployeeById(long id);
					
				List<Employee>getAllEmployee();

				
				

}
