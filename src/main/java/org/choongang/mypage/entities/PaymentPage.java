package org.choongang.mypage.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class PaymentPage {  //결제페이지

    @Id @GeneratedValue
    private String productName; // 상품명

    private String productImage;    // 상품이미지

    private int productQuantity;   // 상품수량

    private String deliveryMethod;  // 배송수단

    private String deliveryAddress; // 배송지

    private String deliveryFee; // 배송비

    private String deliveryNote;    // 배송메모(고객요청사항)

    private String orderer; // 렌탈자

    private int rentalPrice;    // 렌탈가격

    private String rentalPeriod;    // 렌탈 기간

    private String paymentSelection;    // 결제 선택하기 (1.카드결제,2.계좌결제,3.카드&계좌추가하기

    private String paymentCompleted;    // 결제완료 후 selection  이동선택 (1.계속 쇼핑하기,2.렌탈 목록 보기
}
