package org.choongang.mypage.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class rentalDetailsPageAfterClicking {   // 렌탈 내역 상세 페이지

    @Id @GeneratedValue
    private int orderNumber;    // 주문번호

    private String orderDateHour;   // 주문날짜

    private String productImage;    // 상품 이미지

    private String review;  // 상품 리뷰(구매자만)

    private String deliveryTracking;    // 배송 조회

    private int productPrice;  // 상품가격

    private int productQuantity;    // 상품수량

    private String deliveryAddress; // 배송지

    private String recipient;   //  수령인

    private String tel; // 전화번호

    private int orderAmount;    // 주문금액

    private int deliveryFee;    // 배송비

    private int theTotalAmount; // 총금액

    private String purchaseReceiptButton;   // 구매 이동? => purchaseReceipt  구매영수증 클래스 이동
}