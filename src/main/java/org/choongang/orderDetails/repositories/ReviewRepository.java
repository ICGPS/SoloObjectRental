package org.choongang.orderDetails.repositories;

import org.choongang.orderDetails.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long>, QuerydslPredicateExecutor<Review> {
    List<Review> findByProductSeqOrderByCreatedAtDesc(Long productSeq);
}
