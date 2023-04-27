package dev.insaneduck.springbootbackend.repository;

import dev.insaneduck.springbootbackend.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository
        extends JpaRepository<Roles, Integer> {
}
