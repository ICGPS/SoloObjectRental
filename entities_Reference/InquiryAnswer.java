package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class InquiryAnswer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long answerNumber; // 문의사항답변번호

  private String inquiryNumber; // 문의사항번호
  private String answerContent; // 문의사항답변내용
  private String answerAuthor; // 문의사항답변작성자
  private String answerCreationDate; // 문의사항답변작성일
}
