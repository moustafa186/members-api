package com.adviqo.membersapi.member;

public interface IMemberService {
    Member createMember(Member member);

    Iterable<Member> listMembers();

    Member getMember(Long id);

    Member updateMember(Member member, Long id);

    void deleteMember(Long id);
}
