package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class PurchaseReceipt {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long orderNumber; // 주문번호

  private LocalDateTime transactionDateTime; // 거래일시
  private String productName; // 상품명
  private String companyName; // 회사명
  private String signature; // 서명
  private double totalAmount; // 합계
}