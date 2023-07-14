package dev.insaneduck.springbootbackend.repository;


import dev.insaneduck.springbootbackend.entities.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;

    @Test
    @Rollback(value = true)
    void create(){
        String test = "test";
        Book book = Book.builder()
                .title(test)
                .author(test)
                .isbn(test)
                .publisher(test)
                .publicationYear(2099)
                .genre(test)
                .description(test)
                .price(21.99)
                .language(test)
                .pageCount(100)
                .coverImage(test)
                .availability(true)
                .rating(5.5)
                .edition(5)
                .series(test)
                .build();
        bookRepository.save(book);
        assertThat(book.getId()).isGreaterThan(0);
    }

    @Test
    void read(){
        List<Book> bookList = bookRepository.findAll();
        assertTrue(bookList.size()>0);
    }

    @Test
    void readById(){
        Optional<Book> optionalBook = bookRepository.findById(17);
        assertTrue(optionalBook.isPresent());
    }

    @Test
    @Rollback(value = true)
    void update(){
        Optional<Book> optionalBook = bookRepository.findById(20);
        Book book = optionalBook.orElse(null);
        if(book!=null)
        {
            book.setTitle("Test");
            Book book1 = bookRepository.save(book);
            assertThat(book1.getTitle()).isEqualTo("Test");
        }
        else {
            fail();
        }
    }

    @Test
    @Rollback
    void delete(){
        Optional<Book> optionalBook = bookRepository.findById(1);
        Book book = optionalBook.orElse(null);
        if(book!=null)
        {
            bookRepository.delete(book);
            //todo
        }
        else {
            fail();
        }
    }

}