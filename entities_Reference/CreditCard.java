package entities;

import jakarta.persistence.*;

public class CreditCard {

  //카드번호 (Primary Key)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long seq;

  //결제 정보 (외래키)
  @ManyToOne
  @JoinColumn(name = "payment_id")
  private Payment payment;

  //카드번호
  private String cardNumber;

}

