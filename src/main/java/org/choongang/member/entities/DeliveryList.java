package org.choongang.member.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private Member member;

    private boolean defaultAddress;

    private String zonecode;
    private String address;
    private String addressSub;

    public void add(DeliveryList deliveryList) {
    }
}
