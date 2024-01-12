package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Inquiry {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long seq; // 문의사항번호

  private Long memberNumber; // 회원번호
  private int categoryNumber; // 문의사항카테고리번호
  private String title; // 문의사항제목
  private String content; // 문의사항내용
  private String author; // 문의사항작성자
  private String creationDate; // 문의사항작성일
}
