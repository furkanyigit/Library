package com.library.Library.service.dto;

import com.library.Library.entity.Author;
import com.library.Library.entity.Category;
import com.library.Library.entity.Member;
import com.library.Library.entity.Publisher;
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
