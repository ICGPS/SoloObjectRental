package org.choongang.orderDetails.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.choongang.cs.entities.Inquiry;
import org.choongang.member.MemberUtil;
import org.choongang.member.entities.Member;
import org.choongang.orderDetails.controllers.RequestQna;
import org.choongang.orderDetails.entities.QnA;
import org.choongang.orderDetails.repositories.QnARepository;
import org.choongang.product.entities.Product;
import org.choongang.product.service.ProductInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class QnAService {
    private final ProductInfoService productInfoService;
    private final QnARepository qnARepository;
    private final MemberUtil memberUtil;

    public void save(RequestQna form) {
        Product product = productInfoService.get(form.getProductSeq());
        Member member = memberUtil.getMember();

        QnA qna = QnA.builder()
                        .product(product)
                        .content(form.getContent())
                        .member(member)
                        .build();


        qnARepository.saveAndFlush(qna);
    }

    public List<QnA> getQnAList(Long productSeq) {

        return qnARepository.findByProductSeqOrderByCreatedAtDesc(productSeq);
    }

    public List<QnA> getAllList() {
        return qnARepository.findAll();
    }

    public QnA getOne(Long seq) {
        return qnARepository.findById(seq)
                .orElseThrow(() -> new EntityNotFoundException("QnA with seq " + seq + " not found"));
    }
}
