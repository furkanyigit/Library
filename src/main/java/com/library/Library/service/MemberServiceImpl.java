package com.library.Library.service;

import com.library.Library.entity.Book;
import com.library.Library.entity.Member;
import com.library.Library.repository.BookRepository;
import com.library.Library.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member save(Member member) {
        memberRepository.save(member);
        return member;
    }

    @Override
    public Boolean update(Member member, Long memberId) {
        Member dbMember = memberRepository.findById(memberId).orElse(null);
        if(dbMember != null){
            dbMember.setMFirstName(dbMember.getMFirstName());
            dbMember.setMLastName(dbMember.getMLastName());
            dbMember.setEmail(dbMember.getEmail());
            memberRepository.save(dbMember);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean delete(Long memberId) {
        Member dbMember = memberRepository.findById(memberId).orElse(null);
        if(dbMember != null){
            memberRepository.deleteById(memberId);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public List<Book> memberBorrowedList(Long memberId, Long bookId) {
        Book borrowedBook = bookRepository.findById(bookId).orElse(null);
        Member borrowedMember = memberRepository.findById(memberId).orElse(null);
        if(borrowedBook.getStock()> 1){
            borrowedBook.setStock(borrowedBook.getStock()-1);
        }
        borrowedBook.setStock(borrowedBook.getStock()-1);
        return borrowedMember.getBorrowBook();
    }
}