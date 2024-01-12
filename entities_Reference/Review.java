package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Review {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int reviewNumber; // 리뷰번호

  private String reviewBoard; // 리뷰게시판
  private String reviewer; // 리뷰작성자
  private String reviewDate; // 리뷰작성일
  private String reviewContent; // 리뷰내용
  private int productRating; // 상품별점
  private String reviewPhoto; // 리뷰사진
  private String reviewedProduct; // 리뷰제품
}