package dev.insaneduck.springbootbackend.repository;

import dev.insaneduck.springbootbackend.entities.CourseData;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseDataRepository
        extends JpaRepository<CourseData, Integer> {
}
