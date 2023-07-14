package dev.insaneduck.springbootbackend.repository;


import dev.insaneduck.springbootbackend.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
