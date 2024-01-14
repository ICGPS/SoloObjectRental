package entities;

import jakarta.persistence.*;

@Entity
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int seq; // 회원번호 (기본키)

  private String name; // 회원이름
  private String userId; // 회원아이디
  private String password; // 회원비밀번호
  private String email; // 회원이메일
  private String tel; // 회원연락처
  private String userType; // 회원타입
  private String authority; // 회원권한
  private String nation; // 회원국적
  private String address; // 회원주소
  private String bDay; // 회원생년월일
  private String username; // 회원닉네임
  private String expire; // 회원탈퇴여부
  private String agree; // 회원약관동의
  private String gid; // 식별자

  @OneToOne
  @JoinColumn(name = "profileImageId")
  private FileInfo profileImage; // 프로파일이미지

}
