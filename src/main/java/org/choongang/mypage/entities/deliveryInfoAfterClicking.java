package org.choongang.mypage.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class deliveryInfoAfterClicking {

    @Id@GeneratedValue
    private String delivery;    // 기본 배송지

    private String deliveryRegistration;    // 배송지 등록

    private String deliveryInsert;  // 배송지 추가


}
