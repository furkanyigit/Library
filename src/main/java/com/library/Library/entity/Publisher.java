package com.library.Library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Publishers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private Long publisherId;
    @Column(name = "publisher_name")
    private String publisherName;
    @OneToMany(mappedBy = "publisher",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value="publisher-id")
    private List<Book> publisherBooks = new ArrayList<>();
}
