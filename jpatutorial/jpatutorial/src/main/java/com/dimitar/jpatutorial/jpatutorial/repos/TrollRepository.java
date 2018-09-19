package com.dimitar.jpatutorial.jpatutorial.repos;

import com.dimitar.jpatutorial.jpatutorial.entities.Troll;
import org.springframework.data.repository.CrudRepository;

public interface TrollRepository extends CrudRepository <Troll, Integer> {
}
