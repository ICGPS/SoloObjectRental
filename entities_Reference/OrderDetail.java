package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrderDetail {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long seq; // 주문상세번호

  private Long orderNumber; // 주문번호
  private Long productNumber; // 상품번호
  private String productName; // 상품명
  private double rentalPrice; // 렌탈가격
  private int quantity; // 수량
  private int rentalPeriod; // 렌탈기간
  private DeliveryAddress deliveryAddress; // 배송지정보
  private String receiver; // 수령인
  private String contact; // 연락처
  private String deliveryMemo; // 배송메모
  private double orderAmount; // 주문금액
  private double deliveryCost; // 배송비
}