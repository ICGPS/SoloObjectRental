package org.choongang.cs.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.choongang.commons.entities.BaseMember;

@Entity
@Data
public class Inquiry extends BaseMember {
    @Id @GeneratedValue
    private Long seq; // 문의사항 번호
    private Long memberNumber; // 회원번호
    private int categoryNumber; // 문의사항 카테고리 번호
    private String title; // 제목
    private String content; // 내용
    private String author; // 작성자
}
