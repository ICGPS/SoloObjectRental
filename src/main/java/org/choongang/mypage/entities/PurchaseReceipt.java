package org.choongang.mypage.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class PurchaseReceipt {

    @Id @GeneratedValue
    private String productName; //  상품명

    private String transactionDateAndTime;  // 렌탈 거래일시

    private int theTotalAmount; // 총금액

    private String companyName; //  렌탈회사명

    private String signature;   // 서명
}

