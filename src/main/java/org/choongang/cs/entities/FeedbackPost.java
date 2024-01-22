package org.choongang.cs.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "feedback")
public class FeedbackPost {
    @Id
    @GeneratedValue
    private Long seq; // 문의사항 번호

    @Column(length = 50, nullable = false)
    private String author;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(length = 100)
    private String filePath; // 이미지 파일 경로
    
    private LocalDateTime createdAt; // 작성일


    private String feedback;

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @PrePersist
    protected void create() {
        createdAt = LocalDateTime.now();
    }

}























