package org.choongang.orderDetails.entities;

import jakarta.persistence.*;
import lombok.*;
import org.choongang.commons.entities.Base;
import org.choongang.member.entities.Member;
import org.choongang.product.entities.Product;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "qna")
@Builder
public class QnA extends Base {

    @Id
    @GeneratedValue
    private Long seq;

    @ManyToOne(fetch=FetchType.LAZY)
    private Product product;

    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="memberSeq")
    private Member member;

}
















