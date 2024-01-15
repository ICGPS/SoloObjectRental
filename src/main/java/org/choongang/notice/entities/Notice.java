package org.choongang.notice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;


import java.util.Date;


@Entity
@Data
public class Notice {

    @Id @GeneratedValue
    private Long nNum; // 공지사항 번호

    private String aId; // 관리자 아이디

    private String title; // 제목

    private String content; // 내용

    private String writer; // 작성자

    private Date createdAt; // 작성일
}

