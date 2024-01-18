package org.choongang.cs.repositories;

import org.choongang.cs.entities.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface InquiryRepository extends JpaRepository<Inquiry, Long>, QuerydslPredicateExecutor<Inquiry> {

}
