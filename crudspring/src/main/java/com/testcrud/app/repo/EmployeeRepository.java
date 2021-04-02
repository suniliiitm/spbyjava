package com.testcrud.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testcrud.app.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
