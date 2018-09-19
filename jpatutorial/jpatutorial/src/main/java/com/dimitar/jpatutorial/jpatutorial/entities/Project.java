package com.dimitar.jpatutorial.jpatutorial.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="programmers_projects",
            joinColumns = @JoinColumn(name="project_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="programmer_id", referencedColumnName = "id")
    )
    private Set<Programmer> programmers = new HashSet<>();

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

    public Set<Programmer> getProgrammers() {
        return programmers;
    }

    public void setProgrammers(HashSet<Programmer> programmers) {
        this.programmers = programmers;
    }

    public void addProgrammer(final Programmer programmer) {
        if (programmer != null) {
            programmers.add(programmer);
        }
    }
}
