package dev.insaneduck.springbootbackend.repository;

import dev.insaneduck.springbootbackend.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository
        extends JpaRepository<Role, Integer> {
}
