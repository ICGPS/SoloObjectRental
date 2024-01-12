package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FeedbackPost {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int seq; // 게시글번호 (기본키)

  private String author; // 작성자
  private String title; // 제목
  private String content; // 내용
  private int photoNumber; // 사진번호

}
