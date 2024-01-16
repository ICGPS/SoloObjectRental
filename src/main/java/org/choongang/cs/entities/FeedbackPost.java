package org.choongang.cs.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class FeedbackPost {
    @Id
    @GeneratedValue
    private Long seq; // 문의사항 번호
    private String author;
    private String title;
    private String content;
    private int photoNumber;
}
