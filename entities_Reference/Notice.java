package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notice {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long seq; // 공지사항번호

  private Long adminNumber; // 관리자번호
  private String title; // 공지사항제목
  private String content; // 공지사항내용
  private String author; // 공지사항작성자
  private String creationDate; // 공지사항작성일
  private String noticeType; // 공지사항종류
  private Long photoNumber; // 사진번호
}