package entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class CashReceipt {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int purchaseReceiptNumber; // 구매영수증번호 (기본키)

  private String name; // 구매자명
  private String email; // 구매자이메일
  private int orderNum; // 구매자주문번호
  private String productName; // 상품명
  private boolean issueResult; // 발급결과
  private int apprNum; // 승인번호
  private String processor; // 처리자
  private double issueAmt; // 발급금액
  private double supplyAmt; // 공급가액
  private double vat; // 부가세

  @Column(columnDefinition = "TIMESTAMP")
  private LocalDateTime transactionDateTime; // 거래일시

  private String companyName; // 회사명

}
