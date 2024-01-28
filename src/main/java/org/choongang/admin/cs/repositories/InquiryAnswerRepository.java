package org.choongang.admin.cs.repositories;

import org.choongang.cs.entities.InquiryAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InquiryAnswerRepository extends JpaRepository<InquiryAnswer, Long> {
    Optional<InquiryAnswer> findByInquirySeq(Long inquirySeq);
}
