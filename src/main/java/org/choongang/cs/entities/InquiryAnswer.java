package org.choongang.cs.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.choongang.commons.entities.BaseMember;

@Data
@Entity
public class InquiryAnswer extends BaseMember {
    @Id
    @GeneratedValue
    private Long answerSeq;
    private Long inquirySeq; // 문의사항 번호
    private String answerContent;
}
