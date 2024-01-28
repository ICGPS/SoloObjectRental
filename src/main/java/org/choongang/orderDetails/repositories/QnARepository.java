package org.choongang.orderDetails.repositories;

import org.choongang.orderDetails.entities.QnA;
import org.choongang.orderDetails.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface QnARepository extends JpaRepository<QnA, Long>, QuerydslPredicateExecutor<QnA> {
    List<QnA> findByProductSeqOrderByCreatedAtDesc(Long productSeq);

}
