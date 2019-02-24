package com.adviqo.membersapi.member;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.annotation.DirtiesContext.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    private Member m1, m2, m3;
    private List<Member> members;

    @Before
    public void setUp() throws Exception {
        m1 = new Member();
        m1.setFirstName("Moustafa");
        m1.setLastName("Mansour");
        m1.setDateOfBirth(LocalDate.of(1988, 6,18 ));
        m1.setPostalCode("10409");

        m2 = new Member();
        m2.setFirstName("Malik");
        m2.setLastName("Moustafa");
        m2.setDateOfBirth(LocalDate.of(2018, 12,12 ));
        m2.setPostalCode("10409");

        m3 = new Member();
        m3.setFirstName("Ahmed");
        m3.setLastName("Ali");
        m3.setDateOfBirth(LocalDate.of(1988, 8,17 ));
        m3.setPostalCode("11223");

        members = new ArrayList<>();
        members.add(m1);
        members.add(m2);
        members.add(m3);

        memberRepository.saveAll(members);
    }

    @Test
    public void createMember() {
        LocalDate dateOfBirth = LocalDate.of(1988, 4, 18);

        Member m4 = new Member();
        m4.setFirstName("Moustafa");
        m4.setLastName("Mansour");
        m4.setDateOfBirth(dateOfBirth);
        m4.setPostalCode("10409");

        Member createdMember = memberService.createMember(m4);
        assertEquals(Long.valueOf(4), createdMember.getId());
        assertEquals("Moustafa", createdMember.getFirstName());
        assertEquals("Mansour", createdMember.getLastName());
        assertEquals(dateOfBirth, createdMember.getDateOfBirth());
        assertEquals("10409", createdMember.getPostalCode());
    }

    @Test
    public void listMembers() {
        Iterable<Member> members = memberService.listMembers();
        assertEquals(3, ((List<Member>) members).size());
    }

    @Test
    public void getMember() {
        LocalDate dateOfBirth = LocalDate.of(1988, 6, 18);
        Member retrievedMember = memberService.getMember(1L);

        assertNotNull(retrievedMember);
        assertEquals(Long.valueOf(1), retrievedMember.getId());
        assertEquals("Moustafa", retrievedMember.getFirstName());
        assertEquals("Mansour", retrievedMember.getLastName());
        assertEquals(dateOfBirth, retrievedMember.getDateOfBirth());
        assertEquals("10409", retrievedMember.getPostalCode());
    }

    @Test
    public void updateMember() {
        m2.setPostalCode("12345");
        Member updatedMember = memberService.updateMember(m2, 2L);
        assertEquals(Long.valueOf(2), updatedMember.getId());
        assertEquals("12345", updatedMember.getPostalCode());
    }

    @Test
    public void deleteMember() {
        memberService.deleteMember(1L);
        assertEquals(2, memberRepository.count());
    }
}