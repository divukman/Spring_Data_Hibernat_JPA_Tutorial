package com.dimitar.jpatutorial.jpatutorial.repos;

import com.dimitar.jpatutorial.jpatutorial.entities.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends CrudRepository <Customer, Long> {

}
