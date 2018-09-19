package com.dimitar.jpatutorial.jpatutorial.repos;

import com.dimitar.jpatutorial.jpatutorial.entities.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {
}
