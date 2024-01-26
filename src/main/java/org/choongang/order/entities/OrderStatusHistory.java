package org.choongang.order.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.choongang.commons.entities.BaseMember;
import org.choongang.order.constants.OrderStatus;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class OrderStatusHistory extends BaseMember {
    @Id
    @GeneratedValue
    private Long seq;

    private Long orderSeq; // 주문 번호

    @Enumerated(EnumType.STRING)
    @Column(length=30, nullable = false)
    private OrderStatus prevStatus; // 이전 단계

    @Enumerated(EnumType.STRING)
    @Column(length=30, nullable = false)
    private OrderStatus status; // 현재 단계

    private boolean emailSent; // 메일 전송 여부 - 기록이 있다면 자동 전송 X
}
