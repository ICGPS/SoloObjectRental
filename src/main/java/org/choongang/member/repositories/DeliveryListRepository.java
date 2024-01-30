package org.choongang.member.repositories;

import org.choongang.member.entities.DeliveryList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface DeliveryListRepository extends JpaRepository<DeliveryList, Long>, QuerydslPredicateExecutor<DeliveryList> {
}
