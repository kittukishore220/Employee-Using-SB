package com.employee.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.DTO.EmployeeDTO;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRespository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRespository employeeRespository;

	@Override
	public Employee upsert(Employee employee) {
		return employeeRespository.save(employee);
	}

	@Override
	public Employee findById(long eid) {
		Optional<Employee> byId = employeeRespository.findById(eid);

		if (byId.isPresent()) {
			return byId.get();
		}
		return null;
	}

	@Override
	public List<EmployeeDTO> getAll() {
		return employeeRespository.findAll().stream().map(this::getAllEmployee).collect(Collectors.toList());
	}

	private EmployeeDTO getAllEmployee(Employee employee) {
		EmployeeDTO emp = new EmployeeDTO();
		emp.setEid(employee.getEid());
		emp.setEname(employee.getEname());
		emp.setEaddress(employee.getEaddress());
		return emp;

	}

	@Override
	public String deleteById(Long eid) {
		if (employeeRespository.existsById(eid)) {
			employeeRespository.deleteById(eid);
			return "record deleted succefully";
		}

		return "not record found";
	}

	@Override
	public Employee update(Employee employee) {
		Employee orElse = employeeRespository.findById(employee.getEid()).orElse(null);
		if (orElse != null) {
			orElse.setEid(employee.getEid());
			orElse.setEname(employee.getEname());
			orElse.setEaddress(employee.getEaddress());
			orElse.setEpassword(employee.getEpassword());
			return employeeRespository.save(orElse);
		}
		return null;

	}

}
