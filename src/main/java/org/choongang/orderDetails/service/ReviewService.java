package org.choongang.orderDetails.service;

import lombok.RequiredArgsConstructor;
import org.choongang.cs.controllers.RecordInquiry;
import org.choongang.cs.entities.Inquiry;
import org.choongang.member.MemberUtil;
import org.choongang.member.entities.Member;
import org.choongang.member.service.MemberInfo;
import org.choongang.orderDetails.entities.Review;
import org.choongang.orderDetails.repositories.ReviewRepository;
import org.choongang.product.entities.Product;
import org.choongang.product.repositories.ProductRepository;
import org.choongang.product.service.ProductInfoService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MemberUtil memberUtil;

    public void save(Review review) {
        Member member = memberUtil.getMember();
        review.setMember(member);

        reviewRepository.saveAndFlush(review);
    }

    public List<Review> getReviewList(Long productSeq) {
        return reviewRepository.findByProductSeqOrderByCreatedAtDesc(productSeq);
    }

}
