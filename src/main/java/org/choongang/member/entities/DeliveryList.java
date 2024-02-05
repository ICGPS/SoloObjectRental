package org.choongang.member.entities;

import jakarta.persistence.*;
import lombok.*;
import org.choongang.commons.entities.Base;

@Data
@Builder
@Entity
@NoArgsConstructor @AllArgsConstructor
public class DeliveryList extends Base {
    @Id
    @GeneratedValue
    private Long seq;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="memberSeq")
    @ToString.Exclude
    private Member member;

    private boolean defaultAddress;

    private String zonecode;
    private String address;
    private String addressSub;

    public void add(DeliveryList deliveryList) {
    }
}
