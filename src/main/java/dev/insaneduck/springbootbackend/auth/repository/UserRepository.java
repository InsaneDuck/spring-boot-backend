package dev.insaneduck.springbootbackend.auth.repository;

import dev.insaneduck.springbootbackend.auth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends
        JpaRepository<User, Integer> {

    @Query(nativeQuery = false,value = "select u from User u where u.username=:username")
    User findByUserName(String username);
}
