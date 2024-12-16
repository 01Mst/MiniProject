package com.webApplication.smms.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Records {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "record", cascade = CascadeType.ALL) // Changed mappedBy to 'record'
    private List<Entries> entries;

    // Getters and Setters

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

    public List<Entries> getEntries() {
        return entries;
    }

    public void setEntries(List<Entries> entries) {
        this.entries = entries;
    }
}
