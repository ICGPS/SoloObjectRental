package entities;

import jakarta.persistence.*;
import org.apache.tomcat.jni.FileInfo;
import org.choongang.member.Authority;

import java.util.List;

@Entity
public class Board {
  @Id
  private String bid; // 게시판 아이디 (기본키)

  private String bName; // 게시판 이름
  private boolean active; // 사용여부
  private int rowsPerPage; // 1페이지 게시글수
  private int pageCountPc; // pc페이지 구간갯수
  private int pageCountMobile; // mobile 페이지 구간갯수
  private boolean useReply; // 답글사용여부
  private boolean useComment; // 댓글사용여부
  private boolean useEditor; // 에디터 사용여부
  private boolean useUploadImage; // 이미지첨부사용여부
  private boolean useUploadFile; // 파일첨부사용여부
  private String locationAfterWriting; // 글작성후이동위치
  private String skin; // 스킨
  private String category; // 게시판분류

  @Enumerated(EnumType.STRING)
  private Authority listAccessType; // 글목록권한

  @Enumerated(EnumType.STRING)
  private Authority viewAccessType; // 글보기권한

  @Enumerated(EnumType.STRING)
  private Authority writeAccessType; // 글쓰기권한

  @Enumerated(EnumType.STRING)
  private Authority replyAccessType; // 답글권한

  @Enumerated(EnumType.STRING)
  private Authority commentAccessType; // 댓글권한

  private String htmlTop; // 게시판상단
  private String htmlBottom; // 게시판하단

  @OneToMany(mappedBy = "board")
  private List<entities.FileInfo> htmlTopImages; // 게시판 상단 Top이미지 목록

  @OneToMany(mappedBy = "board")
  private List<entities.FileInfo> htmlBottomImages; // 게시판 하단 Bottom 이미지 목록

}
