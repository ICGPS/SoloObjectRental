package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int orderNumber; // 주문번호

  private String processingStatus; // 처리상태
  private String customerName; // 주문자명
  private String phoneNumber; // 휴대전화
  private String address; // 주소
  private String orderMessage; // 주문메세지
  private String consultationRecord; // 상담기록
  private String deliveryStatus; // 배송상태
  private String shippingDate; // 출고일
  private int rentalPeriod; // 렌탈기간
  private String adminMemo; // 관리자메모
  private String paymentMethod; // 결제수단
  private boolean cashReceiptOption; // 현금영수증여부
}