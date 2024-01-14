package entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class MyPage {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long seq; // 마이페이지번호 (Primary)

  @OneToOne
  private Member member; // 회원정보

  @OneToMany
  private List<DeliveryAddress> deliveryAddressList; // 배송지관리

  @OneToMany
  private List<Payment> paymentList; // 결제관리
}
