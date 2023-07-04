package dev.insaneduck.springbootbackend.repository;

import dev.insaneduck.springbootbackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends
        JpaRepository<User, Integer> {
}
