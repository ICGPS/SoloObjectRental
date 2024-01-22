package org.choongang.orderDetails.service;

import lombok.RequiredArgsConstructor;
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

    public void save(Review review) {
        MemberInfo memberInfo = (MemberInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Member member = memberInfo.getMember();

        review.setMemberNumber(member.getSeq());

        reviewRepository.saveAndFlush(review);
    }

}
