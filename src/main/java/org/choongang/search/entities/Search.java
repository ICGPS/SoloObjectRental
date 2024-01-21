package org.choongang.search.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Search {

    @Id @GeneratedValue
    private Long seq;

    private String boardName; // 게시판 이름

    private String title;

    private String content;
    
    private LocalDateTime createdAt; // 게시글 등록일


    public Search() {
        this.createdAt = LocalDateTime.now();
    }

    public Search(String title, String content, String boardName) {
        this.title = title;
        this.content = content;
        this.boardName = boardName;
        this.createdAt = LocalDateTime.now();
    }
}

























