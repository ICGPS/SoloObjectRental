package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CartItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; // 기본키

  private String name; // 상품명
  private int quantity; // 수량
  private String method; // 배송수단
  private double deliveryCost; // 배송비
  private double rentalPrice; // 렌탈가격
  private int rentalPeriod; // 렌탈기간
  private boolean isChecked; // 체크박스

}
