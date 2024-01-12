package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BaseMember {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long seq; // 번호 (기본키)

  private String createdBy; // 생성
  private String modifiedBy; // 수정일

}
