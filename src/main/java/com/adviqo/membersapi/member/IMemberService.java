package com.adviqo.membersapi.member;

import javax.persistence.EntityNotFoundException;

public interface IMemberService {
    Member createMember(Member member);

    Iterable<Member> listMembers();

    Member getMember(Long id) throws EntityNotFoundException;

    Member updateMember(Member member, Long id) throws EntityNotFoundException;

    void deleteMember(Long id) throws EntityNotFoundException;
}
