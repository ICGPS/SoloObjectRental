package org.choongang.cs.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.choongang.commons.entities.BaseMember;

@Data
@Entity
public class InquiryAnswer extends BaseMember {
    @Id
    @GeneratedValue
    private Long answerSeq;

    @Column(unique = true)
    private Long inquirySeq; // 문의사항 번호
    private String answerContent;
}
