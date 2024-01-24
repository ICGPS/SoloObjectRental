package org.choongang.member;

import org.choongang.member.service.FindIdService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FindIdServiceTest {

    @Autowired
    private FindIdService findIdService;

    @Test
    @DisplayName("아이디 전송 및 이메일 전송 테스트")
    void sendTest() {
        assertDoesNotThrow(() -> findIdService.send("beom231231@gmail.com"));
    }
}
