package org.choongang.orderDetails.entities;

import jakarta.persistence.*;
import lombok.*;
import org.choongang.commons.entities.Base;
import org.choongang.member.entities.Member;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "review")
@Builder
public class Review extends Base {
    @Id
    @GeneratedValue
    private Long seq;

    private Long productSeq;

    private double score;

    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="memberSeq")
    private Member member;
}
