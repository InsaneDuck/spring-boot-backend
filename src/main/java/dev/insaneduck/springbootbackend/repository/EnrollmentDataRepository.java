package dev.insaneduck.springbootbackend.repository;

import dev.insaneduck.springbootbackend.entities.EnrollmentData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentDataRepository
        extends JpaRepository<EnrollmentData, Integer> {
}
