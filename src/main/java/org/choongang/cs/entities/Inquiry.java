package org.choongang.cs.entities;

import jakarta.persistence.*;
import lombok.*;
import org.choongang.commons.entities.Base;
import org.choongang.commons.entities.BaseMember;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "inquiry")
@Builder
public class Inquiry extends Base {

    @Id
    @GeneratedValue
    private Long seq; // 문의사항 번호

    @Column(length = 19, nullable = false)
    private Long memberNumber; // 회원번호

    @Column(length = 10, nullable = false)
    private int categoryNumber; // 문의사항 카테고리 번호

    @Column(length = 255, nullable = false)
    private String title; // 제목

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content; // 내용

    @Column(length = 255, nullable = false)
    private String author; // 작성자
}
