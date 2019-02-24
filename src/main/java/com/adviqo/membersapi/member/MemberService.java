package com.adviqo.membersapi.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    public Iterable<Member> listMembers() {
        return memberRepository.findAll();
    }

    public Member getMember(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Member with id " + id + " was not found."));
    }

    public Member updateMember(Member member, Long id) {
        Optional<Member> memberToUpdate = memberRepository.findById(id);
        if(memberToUpdate.isPresent()) {
            member.setId(id);
            return memberRepository.save(member);
        } else {
            throw new EntityNotFoundException("Member with id " + id + " was not found.");
        }
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

}
