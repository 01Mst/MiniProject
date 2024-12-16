package com.webApplication.smms.model;

import jakarta.persistence.*;

@Entity
public class Entries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentName;
    private Double total;

    @ManyToOne
    @JoinColumn(name = "record_id") // Changed column name to 'record_id'
    private Records record;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Records getRecord() {
        return record;
    }

    public void setRecord(Records record) {
        this.record = record;
    }
}
