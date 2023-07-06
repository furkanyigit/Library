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
@Table(name = "Members")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Member{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;
    @Column(name = "member_first_name")
    private String mFirstName;
    @Column(name = "member_last_name")
    private String mLastName;
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value="member-id")
    private Set<Book> borrowBook = new HashSet<Book>();
}
