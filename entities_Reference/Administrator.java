package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Administrator {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int adminNumber; // 관리자번호

  private String adminName; // 관리자이름
  private String adminID; // 관리자아이디
  private String adminPassword; // 관리자비밀번호
  private String adminLevel; // 관리자등급
}
