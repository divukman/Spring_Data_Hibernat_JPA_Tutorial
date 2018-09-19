package com.dimitar.jpatutorial.jpatutorial.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private Set<PhoneNumber> numbers = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PhoneNumber> getNumbers() {
        return numbers;
    }

    public void addPhoneNumber(final PhoneNumber number) {
        if (number != null) {
            numbers.add(number);
            number.setCustomer(this);
        }
    }
}