package entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Payment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long seq; // 결제번호 (Primary)

  private String accountNumber; // 계좌번호
  private String cardNumber; // 카드번호
  private boolean isCardRegistered; // 카드등록
  @OneToMany
  private List<CreditCard> creditCardList; // 카드목록
}