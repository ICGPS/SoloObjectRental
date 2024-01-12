package org.choongang.mypage.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class rentalStationAfterClicking {   //렌탈내역

    @Id @GeneratedValue
    private int productNumber;  // 상품번호

    private String productName;    // 상품명

    private String productImage;    // 상품이미지

    private String productPrice;    // 가격

    private String StartDate;   // 시작일

    private String endDate; //종료일

    private String sitvation;   // 상태 표시 (사용가능, 예약중, 렌탈중, 렌탈가능)

    private String rentalDetailsPage;  // AfterClicking 클릭시 제품 상세 페이지 이동

    private String theTotalAmount;  // 총금액
}
