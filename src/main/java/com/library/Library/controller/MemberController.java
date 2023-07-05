package com.library.Library.controller;

import com.library.Library.entity.Book;
import com.library.Library.entity.Member;
import com.library.Library.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberServiceImpl memberService;

    @GetMapping("/get-all")
    public List<Member> getAll(){
        return memberService.getAll();
    }
    @PostMapping("/save")
    public ResponseEntity<Member> save(@RequestBody Member member){
        Member member1 = memberService.save(member);
        return new ResponseEntity<>(member1, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public Boolean update(@RequestBody Member member, @RequestParam Long memberId){
        return memberService.update(member,memberId);
    }
    @PostMapping("/borrowed")
    public List<Book> memberBorrowedList(@RequestParam Long memberId, @RequestParam Long bookId){
        return memberService.memberBorrowedList(memberId,bookId);
    }

    @DeleteMapping("delete/{id}")
    public Boolean delete(@RequestParam Long memberId){
        return memberService.delete(memberId);
    }
}