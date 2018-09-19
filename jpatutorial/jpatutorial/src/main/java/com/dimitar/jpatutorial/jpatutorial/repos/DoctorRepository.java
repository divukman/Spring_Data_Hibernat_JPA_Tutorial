package com.dimitar.jpatutorial.jpatutorial.repos;

import com.dimitar.jpatutorial.jpatutorial.entities.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository <Doctor, Long> {
}
