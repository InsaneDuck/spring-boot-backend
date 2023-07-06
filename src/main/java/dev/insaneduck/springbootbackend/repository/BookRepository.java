package dev.insaneduck.springbootbackend.repository;


import dev.insaneduck.springbootbackend.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book,Integer> {
}
