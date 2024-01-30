package org.choongang.admin.cs.service;

import lombok.RequiredArgsConstructor;
import org.choongang.admin.cs.repositories.InquiryAnswerRepository;
import org.choongang.cs.entities.InquiryAnswer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class InquiryAnswerService {
    private final InquiryAnswerRepository inquiryAnswerRepository;

    public InquiryAnswer save(InquiryAnswer inquiryAnswer) {
        try {
            InquiryAnswer data = inquiryAnswerRepository.saveAndFlush(inquiryAnswer);
        } catch (Exception e) {}
        return inquiryAnswer;
    }

    public InquiryAnswer getOne(Long inquirySeq) {
        return inquiryAnswerRepository.findByInquirySeq(inquirySeq).orElse(new InquiryAnswer());
    }

}
