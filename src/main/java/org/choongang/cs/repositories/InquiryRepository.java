package org.choongang.cs.repositories;

import org.choongang.cs.entities.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;
import java.util.Optional;

public interface InquiryRepository extends JpaRepository<Inquiry, Long>, QuerydslPredicateExecutor<Inquiry> {
    List<Inquiry> findByMemberNumber(Long memberNumber);

    Optional<Inquiry> findBySeq(Long seq);// 얘는 findById로 이미 구현이 돼있음, 근데 연습이니까 하나 만들자
}
