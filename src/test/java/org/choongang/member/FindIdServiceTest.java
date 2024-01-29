package org.choongang.member;

import org.choongang.member.entities.Member;
import org.choongang.member.repositories.MemberRepository;
import org.choongang.member.service.FindIdService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active=test")
public class FindIdServiceTest {

    @Autowired
    private MemberRepository repository;

    @Autowired
    private FindIdService service;

    private Member member;

    @BeforeEach
    void init() {
        member = new Member();
        member.setUserId("user01");
        member.setName("사용자01");
        member.setUserName("사용자01");
        member.setEmail("beom231231@gmail.com");
        member.setPassword("12345678");
        member.setBDay("19970");
        member.setGid("1234");
        member.setTel("1234");
        repository.saveAndFlush(member);
    }

    @Test
    void test1() {
        assertDoesNotThrow(() -> service.sendUserId(member.getUserId(), member.getEmail()));
    }

    /*
    @Autowired
    private FindIdService findIdService;

    @Test
    @DisplayName("아이디 전송 및 이메일 전송 테스트")
    void sendTest() {
        assertDoesNotThrow(() -> findIdService.send("beom231231@gmail.com"));
    }*/
}
