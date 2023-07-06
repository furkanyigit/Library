package com.library.Library.service;

import com.library.Library.entity.Author;
import com.library.Library.entity.Book;
import com.library.Library.entity.Member;
import com.library.Library.repository.BookRepository;
import com.library.Library.repository.MemberRepository;
import com.library.Library.service.dto.AuthorDto;
import com.library.Library.service.dto.BookDto;
import com.library.Library.service.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    private Member changedMemberDtoToMember(MemberDto memberDto){
        Member member = new Member();
        //member.setMemberId(memberDto.getMemberId());
        member.setMFirstName(memberDto.getMFirstName());
        member.setMLastName(memberDto.getMLastName());
        member.setEmail(memberDto.getEmail());
        return member;
    }

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    BookServiceImpl bookService;

    @Override
    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member save(MemberDto memberDto) {
        Member member = changedMemberDtoToMember(memberDto);
        memberRepository.save(member);
        return member;
    }

    @Override
    public Boolean update(MemberDto memberDto, Long memberId) {
        Member dbMember = memberRepository.findById(memberId).orElse(null);
        Member member = changedMemberDtoToMember(memberDto);
        if(dbMember != null){
            dbMember.setMFirstName(member.getMFirstName());
            dbMember.setMLastName(member.getMLastName());
            dbMember.setEmail(member.getEmail());
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
    public Book memberBorrowedList(Long memberId, Long bookId){
        Book borrowedBook = bookRepository.findById(bookId).orElse(null);
        Member borrowedMember = memberRepository.findById(memberId).orElse(null);
        if(borrowedBook.getStock()>0){
            borrowedBook.setStock(borrowedBook.getStock()-1);
            borrowedMember.getBorrowBook().add(borrowedBook);
            //borrowedBook.setMember(borrowedMember);
            bookRepository.save(borrowedBook);
            memberRepository.save(borrowedMember);
        }
        return borrowedBook;
    }
}