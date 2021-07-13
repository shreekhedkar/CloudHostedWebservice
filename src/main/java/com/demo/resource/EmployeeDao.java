package com.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDao {

	@Autowired
	EmployeeStorage empStorage;

	public Employee getEmpById(int eno) {

		return empStorage.getEmpById(eno);
	}

	public List<Employee> getEmployees() {

		return empStorage.getEmployeeList();
	}

	public void addEmployee(Employee e) {

		empStorage.addEmpToList(e);
	}

	public void deleteEmployee(int eno) {
		// TODO Auto-generated method stub
		empStorage.deleteEmpFromList(eno);
	}

}
