package dev.insaneduck.springbootbackend.repository;

import dev.insaneduck.springbootbackend.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository
        extends JpaRepository<Student, Integer> {
}
