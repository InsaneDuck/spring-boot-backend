package dev.insaneduck.springbootbackend.repository;

import dev.insaneduck.springbootbackend.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository
        extends JpaRepository<Instructor, Integer> {
}
