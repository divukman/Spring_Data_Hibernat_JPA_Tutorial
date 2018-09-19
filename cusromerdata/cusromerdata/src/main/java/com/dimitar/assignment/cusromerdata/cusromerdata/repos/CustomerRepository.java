package com.dimitar.assignment.cusromerdata.cusromerdata.repos;

import com.dimitar.assignment.cusromerdata.cusromerdata.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository <Customer, Long> {
}
