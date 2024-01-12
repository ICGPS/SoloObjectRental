package entities;

import jakarta.persistence.*;

@Entity
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int productNumber; // 상품번호 (기본키)

  private String productName; // 상품명
  private String category; // 카테고리
  private String productCode; // 코드
  private double rentalFee; // 렌탈료
  private double consumerPrice; // 소비자가
  private int stock; // 재고
  private String itemCondition; // 물품상황
  private String returnDate; // 반납일
  private String shippingDate; // 출고일
  private String image; // 이미지

  @Column(columnDefinition = "TIMESTAMP")
  private String registrationDate; // 등록일

  @Column(columnDefinition = "TIMESTAMP")
  private String modificationDate; // 수정일

  private String registrant; // 등록자
  private String modifier; // 수정자
  private int rentalCount; // 렌탈횟수
  private int productRating; // 상품별점

}
