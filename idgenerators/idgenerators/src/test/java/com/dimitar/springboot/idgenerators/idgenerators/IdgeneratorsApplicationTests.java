package com.dimitar.springboot.idgenerators.idgenerators;

import com.dimitar.springboot.idgenerators.idgenerators.entities.Employee;
import com.dimitar.springboot.idgenerators.idgenerators.repos.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IdgeneratorsApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	public void testCreateEmployee() {
		final Employee employee = new Employee();
		employee.setName("Jean Luc");
		employeeRepository.save(employee);
	}

}
