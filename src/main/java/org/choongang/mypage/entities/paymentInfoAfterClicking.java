package org.choongang.mypage.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class paymentInfoAfterClicking {

    @Id @GeneratedValue
    private int defaultCard;  // 기본값에 사용중 카드

    private int addCard; // 카드 추가 등록

    private int deleteCard; // 카드 삭제

    private int defaultAccount; // 기본값 용중인 계좌

    private int addAccount; // 계좌 추가 등록

    private int deleteAccount;  // 계좌 삭제
}