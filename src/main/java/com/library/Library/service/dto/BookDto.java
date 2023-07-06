package com.library.Library.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BookDto {

    //private Long bookId;
    private String bookName;
    private int pages;
    private LocalDate publishDate;
    private int stock;
    private Long authorId;
    private Long categoryId;
    private Long memberId;
    private Long publisherId;

}
