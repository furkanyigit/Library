package com.library.Library.controller;

import com.library.Library.entity.Book;
import com.library.Library.entity.Member;
import com.library.Library.service.MemberServiceImpl;
import com.library.Library.service.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Member> save(@RequestBody MemberDto memberDto){
        Member member = memberService.save(memberDto);
        return new ResponseEntity<>(member, HttpStatus.CREATED);
    }

    @PutMapping("/update/{memberId}")
    public Boolean update(@RequestBody MemberDto memberDto, @PathVariable Long memberId){
        return memberService.update(memberDto,memberId);
    }
    @PostMapping("/borrowed")
    public Book memberBorrowedList(@RequestParam Long memberId, @RequestParam Long bookId){
        return memberService.memberBorrowedList(memberId,bookId);
    }

    @DeleteMapping("delete/{id}")
    public Boolean delete(@PathVariable Long id){
        return memberService.delete(id);
    }
}
