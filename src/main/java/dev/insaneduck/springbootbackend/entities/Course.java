package dev.insaneduck.springbootbackend.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Course {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "department")
    private String department;
    @Basic
    @Column(name = "code")
    private String code;

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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id && Objects.equals(name, course.name) && Objects.equals(department, course.department) && Objects.equals(code, course.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, department, code);
    }
}
