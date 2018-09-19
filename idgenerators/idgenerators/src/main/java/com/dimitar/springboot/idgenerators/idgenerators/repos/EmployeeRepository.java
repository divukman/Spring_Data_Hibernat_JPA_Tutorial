package com.dimitar.springboot.idgenerators.idgenerators.repos;

import com.dimitar.springboot.idgenerators.idgenerators.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository  extends CrudRepository <Employee, Long>{
}
