package org.choongang.mypage.entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class MyPage {

    @Id @GeneratedValue
    private String userName; // 사용자 이름

    private String nickname; // 닉네임

    private String myInfo; // 내정보관리 AfterClicking 클릭시 정보관리 이동

    private String rentalStation; // 렌탈네역 AfterClicking 클릭후  렌탈네역 이동

    private String shoppingCartIcon; // 장바구니 AfterClicking 클릭후 장바구니 이동

    private String inquiry; // 1:1 문의 AfterClicking 1:1문의 이동

}
