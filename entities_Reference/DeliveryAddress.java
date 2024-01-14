package entities;

import jakarta.persistence.*;

@Entity
public class DeliveryAddress {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long seq; // 배송지번호 (Primary)

  private String address; // 주소
  private String postalCode; // 우편찾기
  private String addAddress; // 배송지추가

  @OneToOne
  private Member member; // 회원번호 (외래키)
  private String receiver; // 수령인
  private String contact; // 연락처
}