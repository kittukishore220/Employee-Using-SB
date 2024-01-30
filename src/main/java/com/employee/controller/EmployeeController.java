package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.DTO.EmployeeDTO;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/insert")
	public ResponseEntity<Employee> insert(@RequestBody Employee employee) {
		Employee save = employeeService.upsert(employee);
		return new ResponseEntity<>(save, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<EmployeeDTO>> getAllEmp() {
		List<EmployeeDTO> all = employeeService.getAll();
		return new ResponseEntity<>(all, HttpStatus.OK);
	}

	@GetMapping("/id/{eid}")
	public ResponseEntity<Employee> employeeById(@PathVariable Long eid) {
		Employee byId = employeeService.findById(eid);
		return new ResponseEntity<>(byId, HttpStatus.OK);
	}

	@DeleteMapping("delete/{eid}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable long eid) {
		String deleteById = employeeService.deleteById(eid);
		return new ResponseEntity<String>(deleteById, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Employee update = employeeService.update(employee);
		return new ResponseEntity<Employee>(update, HttpStatus.OK);

	}

}
