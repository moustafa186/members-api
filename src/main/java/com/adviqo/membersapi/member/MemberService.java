package com.adviqo.membersapi.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class MemberService implements IMemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Iterable<Member> listMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMember(Long id) throws EntityNotFoundException {
        return memberRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Member with id " + id + " was not found."));
    }

    @Override
    public Member updateMember(Member member, Long id) throws EntityNotFoundException {
        Optional<Member> memberToUpdate = memberRepository.findById(id);
        if(memberToUpdate.isPresent()) {
            member.setId(id);
            return memberRepository.save(member);
        } else {
            throw new EntityNotFoundException("Member with id " + id + " was not found.");
        }
    }

    @Override
    public void deleteMember(Long id) throws EntityNotFoundException {
        try {
            memberRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Member with id " + id + " was not found.");
        }
    }
}
