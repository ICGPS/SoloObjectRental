package org.choongang.cs.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.choongang.commons.entities.BaseMember;

@Entity
@Data
@Builder
public class Inquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq; // 문의사항 번호

    @Column(length = 100, nullable = false)
    private Long memberNumber; // 회원번호

    @Column(length = 50, nullable = false)
    private int categoryNumber; // 문의사항 카테고리 번호

    @Column(length = 500, nullable = false)
    private String title; // 제목

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content; // 내용
}
