package org.choongang.mypage.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ShoppingBasket {   // 장바구니

    @Id @GeneratedValue
    private String productName; // 상품명

    private String productImage;    // 상품이미지

    private int quantity;   // 상품 수량

    private String deliveryMethod; // 배송수단 (택배,직접)

    private int deliveryFee;    // 배송비

    private int rentalPrice; // 렌탈 가격

    private String rentalPeriod;    // 렌탈 기간

    private int theTotalAmount; // 총금액

    private String paymentPage; //  렌탈결제 페이지 AfterClicking 클릭후 렌탈 결제 페이지 이동

    private String productPage; //  계속쇼핑하기 버튼 AfterClicking 클릭후 상품 카테고리 페이지 이동

    private String productDelete; // 상품삭제
}
