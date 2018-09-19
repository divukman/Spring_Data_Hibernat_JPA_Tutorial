package com.dimitar.jpatutorial.jpatutorial.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Programmer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private int salary;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "programmers")
    private Set<Project> projects = new HashSet<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(HashSet<Project> projects) {
        this.projects = projects;
    }

    public void addProject(final Project project) {
        if (project != null) {
            projects.add(project);
        }
    }
}
