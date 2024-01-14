package entities;

import jakarta.persistence.*;

@Entity
public class Authorities {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long seq; // 번호 (기본키)

  @ManyToOne
  @JoinColumn(name = "member_id")
  private Member member; // 회원번호 (외래키)

  private String authority; // 권한

}
