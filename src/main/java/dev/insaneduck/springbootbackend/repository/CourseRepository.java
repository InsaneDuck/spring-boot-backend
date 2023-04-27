package dev.insaneduck.springbootbackend.repository;

import dev.insaneduck.springbootbackend.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository
        extends JpaRepository<Course, Integer> {
}
