package com.dimitar.springboot.idgenerators.idgenerators.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Employee {

    @GenericGenerator(name="emp_id", strategy = "com.dimitar.springboot.idgenerators.idgenerators.CustomRandomIDGenerator")
    @Id
    @GeneratedValue(generator = "emp_id")
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
