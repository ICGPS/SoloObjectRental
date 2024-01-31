package org.choongang.orderDetails.service;

import lombok.RequiredArgsConstructor;
import org.choongang.cs.entities.Inquiry;
import org.choongang.member.MemberUtil;
import org.choongang.member.entities.Member;
import org.choongang.orderDetails.entities.QnA;
import org.choongang.orderDetails.repositories.QnARepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class QnAService {

    private final QnARepository qnARepository;
    private final MemberUtil memberUtil;

    public void save(QnA qnA) {
        Member member = memberUtil.getMember();
        qnA.setMember(member);

        qnARepository.saveAndFlush(qnA);
    }

    public List<QnA> getQnAList(Long productSeq) {

        return qnARepository.findByProductSeqOrderByCreatedAtDesc(productSeq);
    }

    public List<QnA> getAllList() {
        return qnARepository.findAll();
    }
}
