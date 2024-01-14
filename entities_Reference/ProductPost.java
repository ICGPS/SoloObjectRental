package entities;

import jakarta.persistence.*;

public class ProductPost {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long seq; //상품게시글번호

  @Column(name = "category_number")
  private int categoryNumber; //상품카테고리번호

  @ManyToOne
  @JoinColumn(name = "member_number")
  private Member memberNumber; //회원번호 (외래키)

  @Column(name = "photo_number")
  private int photoNumber; //사진번호


  private String content; //상품게시글내용

  private String author; //상품게시글작성자


  @Column(name = "creation_date")
  private String creationDate; //상품게시글작성일
}