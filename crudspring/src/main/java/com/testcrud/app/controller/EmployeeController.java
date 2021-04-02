package com.testcrud.app.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.testcrud.app.model.Employee;
import com.testcrud.app.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService; ;
	
	
	
	
	
	// display list of employees
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployee" ,employeeService.getAllEmployee());
		
		return "index";
		
		
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		System.out.println("hi sunil");
		Employee employee=new Employee();
		
		model.addAttribute("employee",employee);
		System.out.println("Employee"+employee);
		
		return "new_employee";
		
		
	} 
	@PostMapping("/saveEmployee")
	 public String saveEmployee(@ModelAttribute("employee") Employee employee) {
	     // save employee to database
	    this.employeeService.saveEmployee(employee);
	     return "redirect:/";
	 }
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
	 
	 // get employee from the service
	 Employee employee = employeeService.getEmployeeById(id);
	 
	 // set employee as a model attribute to pre-populate the form
	 model.addAttribute("employee", employee);
	 return "update_employee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value = "id") long id) {
	 
	 // call delete employee method 
	 this.employeeService.deletebyEmployeeId(id);
	 return "redirect:/";
	}
	

}
