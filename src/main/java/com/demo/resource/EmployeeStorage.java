package com.demo.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeStorage {

	List<Employee> emp = new ArrayList<Employee>();

	public List<Employee> getEmployeeList() {
		return emp;
	}

	public void addEmpToList(Employee e) {

		emp.add(e);
	}

	void deleteEmpFromList(int eno) {

		emp.removeIf(e -> e.getEno() == eno);
	}

	public Employee getEmpById(int eno) {

		// Optional<Employee> filteredEmp = emp.stream().findAny().filter(p ->
		// p.getEno() == eno);

		for (Employee e : emp) {

			if (e.getEno() == eno) {
				return e;
			}
		}

		return new Employee();

	}

}
