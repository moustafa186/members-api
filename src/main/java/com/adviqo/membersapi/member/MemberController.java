package com.adviqo.membersapi.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping("/members")
    public Member createMember(@RequestBody Member member) {
        return memberService.createMember(member);
    }

    @GetMapping("/members")
    public Iterable<Member> listMembers() {
        return memberService.listMembers();
    }

    @GetMapping("/members/{id}")
    public Member readMember(@PathVariable Long id) {
        return memberService.getMember(id);
    }

    @PutMapping("/members/{id}")
    public Member readMember(@RequestBody Member member, @PathVariable Long id) {
        return memberService.updateMember(member, id);
    }

    @DeleteMapping ("/members/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }
}
