package com.dimitar.jpatutorial.jpatutorial.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //@Column(name="first_name")
    private String firstName;

   // @Column(name="last_name")
    private String lastName;

    private String speciality;


    @ManyToMany(mappedBy = "doctors")
    private List<Patient> patients;

    @OneToMany
    private List<Appointment> appointments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}
