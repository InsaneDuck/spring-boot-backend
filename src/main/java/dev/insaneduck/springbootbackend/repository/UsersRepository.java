package dev.insaneduck.springbootbackend.repository;

import dev.insaneduck.springbootbackend.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends
        JpaRepository<Users, Integer> {
}
