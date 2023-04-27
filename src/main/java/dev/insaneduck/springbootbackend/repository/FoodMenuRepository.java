package dev.insaneduck.springbootbackend.repository;

import dev.insaneduck.springbootbackend.entities.FoodMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodMenuRepository
        extends JpaRepository<FoodMenu, Integer> {
}
