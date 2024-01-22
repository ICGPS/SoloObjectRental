package org.choongang.orderDetails.service;

import lombok.RequiredArgsConstructor;
import org.choongang.member.MemberUtil;
import org.choongang.member.entities.Member;
import org.choongang.member.service.MemberInfo;
import org.choongang.orderDetails.entities.Review;
import org.choongang.orderDetails.repositories.ReviewRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MemberUtil memberUtil;
    public void save(Review review) {
        Member member = memberUtil.getMember();
        review.setMemberNumber(member.getSeq());
        System.out.println(review);
        reviewRepository.saveAndFlush(review);
    }

}
