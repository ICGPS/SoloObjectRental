package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CategoryOption {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long seq; // 카테고리번호

  private String categoryName; // 카테고리이름
}