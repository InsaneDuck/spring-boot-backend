package dev.insaneduck.springbootbackend.repository;

import dev.insaneduck.springbootbackend.entities.ExpenseItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseItemRepository
        extends JpaRepository<ExpenseItem, Integer> {
}
