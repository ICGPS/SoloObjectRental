package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FileInfo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long seq; // 파일 등록번호

  private String gid; // 파일 관리자
  private String location; // 파일 저장지역
  private String fileName; // 파일 이름
  private String extension; // 파일 확장자
  private String fileType; // 파일 타입
  private String filePath; // 서버에 실제 올라간 경로
  private String fileUrl; // 브라우저 접근 경로
  private String thumbsPath; // 썸네일 이미지 경로
  private String thumbsUrl; // 브라우저 주소창 입력 접근
}
