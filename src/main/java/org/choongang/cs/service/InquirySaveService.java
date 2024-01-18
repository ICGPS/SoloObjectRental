package org.choongang.cs.service;

import lombok.RequiredArgsConstructor;
import org.choongang.cs.controllers.InquirySave;
import org.choongang.cs.entities.Inquiry;
import org.choongang.cs.repositories.InquiryRepository;
import org.choongang.member.entities.Member;
import org.choongang.member.service.MemberInfo;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

@Service
@RequiredArgsConstructor
@Transactional
public class InquirySaveService {

    private final InquiryRepository inquiryRepository;

    public void save(InquirySave inquirySave) {
        MemberInfo memberInfo = (MemberInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Member member = memberInfo.getMember();

        inquiryRepository.saveAndFlush(Inquiry.builder()
                .seq(1L)
                .memberNumber(member.getSeq())
                .categoryNumber(1)
                .title(inquirySave.title())
                .content(inquirySave.content())
                .author(member.getName())
                .build());
    }
}

/**
 * 1. 엔티티 생성
 *  엔티티가 뭔데? 테이블 조회/입력/수정/삭제 하기위해 데이터를 담을 그릇
 *  왜 생성? 생성을 해야 사용을 할 수 있지, 객체지향이니까
 *
 * 2. 레파지토리 생성
 *  제네릭으로 엔티티를 넣어준다
 *   왜? 레파지토리에 어떤 테이블의 접근할것이다 라고 알려주려고
 *
 * 3. 서비스 생성
 *  컨트롤러는 서비스를 호출하는 역할, 서비스에 업무로직(유효성검증, 다른 데이터 조회 후 비교, 데이터 비교 등 어떤 행위)이 존재
 *
 *
 * 화면 -> 컨트롤러 -> 서비스 -> 레파지토리 -> 테이블
 *            레코드       레코드     엔티티
 */

