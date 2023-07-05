package com.library.Library.service;

import com.library.Library.entity.Author;
import com.library.Library.entity.Book;
import com.library.Library.entity.Member;

import java.util.List;

public interface MemberService {

    List<Member> getAll();
    Member save(Member member);
    Boolean update(Member author, Long memberId);
    Boolean delete(Long memberId);
    List<Book> memberBorrowedList(Long memberId, Long bookId);
}