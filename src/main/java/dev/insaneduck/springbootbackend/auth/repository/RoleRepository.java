package dev.insaneduck.springbootbackend.auth.repository;

import dev.insaneduck.springbootbackend.auth.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository
        extends JpaRepository<Role, Integer> {
}
