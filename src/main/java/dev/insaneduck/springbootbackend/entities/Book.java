package dev.insaneduck.springbootbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "book",schema = "data")
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "publication_year")
    private Integer publicationYear;
    @Column(name = "genre")
    private String genre;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Double price;
    @Column(name = "language")
    private String language;
    @Column(name = "page_count")
    private Integer pageCount;
    @Column(name = "cover_image")
    private String coverImage;
    @Column(name = "availability")
    private Boolean availability;
    @Column(name = "rating")
    private Double rating;
    @Column(name = "edition")
    private Integer edition;
    @Column(name = "series")
    private String series;
}