package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Base {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long seq; // 일자 base 번호

  private LocalDateTime createdBy; // 작성일
  private LocalDateTime modifiedBy; // 수정일
}
