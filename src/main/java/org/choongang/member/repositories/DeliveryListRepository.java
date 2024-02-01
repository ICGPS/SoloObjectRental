package org.choongang.member.repositories;

import org.choongang.member.entities.DeliveryList;
import org.choongang.member.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface DeliveryListRepository extends JpaRepository<DeliveryList, Long>, QuerydslPredicateExecutor<DeliveryList> {

//    public List<DeliveryList> findDeliveryListByMember(Member memebr);
}
