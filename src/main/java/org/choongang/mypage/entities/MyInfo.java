package org.choongang.mypage.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class MyInfo {
    @Id
    @GeneratedValue
    private String userName; // 사용자 이름

    private String nickname; // 닉네임

    private String tel; // 전화번호

    private String email; // 이메일

    private String address; // 주소

    private String deliveryInfo; // 배송지 관리 AfterClicking 배송지 관리 이동

    private String paymentInfo; // 결제 관리 AfterClicking 결제 관리 이동

    private String myInfoUpdater; // 수정 AfterClicking 수정 기능

    private String delete; // 탈퇴
}