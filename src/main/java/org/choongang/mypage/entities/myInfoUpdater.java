package org.choongang.mypage.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class myInfoUpdater {

    @Id @GeneratedValue
    private String userName; // 사용자 이름

    private String nickname; // 닉네임

    private String tel; // 전화번호

    private String email; // 이메일

    private String address; // 주소

    private String password; // 패스워드 (현재)

    private String newPassword; // 패스워드 (변경)

    private String currentPassword; // 패스워드 (변경 확인)


    private String myInfoUpdater; // 수정 AfterClicking 수정!!

    private String delete; // 탈퇴
}
