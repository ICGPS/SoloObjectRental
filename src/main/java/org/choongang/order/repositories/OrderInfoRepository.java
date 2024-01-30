package org.choongang.order.repositories;

import org.choongang.order.entities.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface OrderInfoRepository extends JpaRepository<OrderInfo, Long>, QuerydslPredicateExecutor<OrderInfo> {

    // 주문자명으로 주문 정보 조회
    List<OrderInfo> findByorderEmail(String orderName);
}