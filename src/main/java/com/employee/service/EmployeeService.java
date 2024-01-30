package com.employee.service;

import java.util.List;

import com.employee.DTO.EmployeeDTO;
import com.employee.entity.Employee;

public interface EmployeeService {

	public Employee upsert(Employee employee);

	public Employee findById(long eid);

	public List<EmployeeDTO> getAll();

	public String deleteById(Long eid);

	public Employee update(Employee employee);

}
