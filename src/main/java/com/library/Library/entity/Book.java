package com.library.Library.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Books")
@Getter
@Setter
public class Book  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;
    @Column(name = "kitap_adi")
    private String bookName;
    @Column(name = "pages")
    private int pages;
    @Column(name = "date")
    private LocalDate publishDate;
    @Column(name = "book_stock")
    private int stock;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value="author-id")
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value="category-id")
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value="member-id")
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value="publisher-id")
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;
}
