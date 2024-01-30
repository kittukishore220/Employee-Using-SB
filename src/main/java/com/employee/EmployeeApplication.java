package com.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRespository;

@SpringBootApplication
public class EmployeeApplication implements CommandLineRunner {
	@Autowired
	private EmployeeRespository employeeRespository;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Employee emp = new Employee();
		emp.setEid(123);
		emp.setEname("Rohith");
		emp.setEaddress("Vijayawada");
		emp.setEpassword("Rohith123");

		employeeRespository.save(emp);
		//System.out.println(emp);
	}

}
