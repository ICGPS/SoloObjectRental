package org.choongang.cs.service;

import lombok.RequiredArgsConstructor;
import org.choongang.cs.controllers.RecordInquiry;
import org.choongang.cs.controllers.InquirySave;
import org.choongang.cs.entities.Inquiry;
import org.choongang.cs.repositories.InquiryRepository;
import org.choongang.member.entities.Member;
import org.choongang.member.service.MemberInfo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class InquiryService {

    private final InquiryRepository inquiryRepository;

    public void save(InquirySave inquirySave) {
        MemberInfo memberInfo = (MemberInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Member member = memberInfo.getMember();

        inquiryRepository.saveAndFlush(Inquiry.builder()
                .memberNumber(member.getSeq())
                .categoryType(inquirySave.inquiryType())
                .title(inquirySave.title())
                .content(inquirySave.content())
                .author(member.getName())
                .build());
    }

    public List<RecordInquiry> getList() {
        MemberInfo memberInfo = (MemberInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Member member = memberInfo.getMember();

        List<Inquiry> listInquiry = inquiryRepository.findByMemberNumber(member.getSeq());
        List<RecordInquiry> listRecordInquiry = new ArrayList<RecordInquiry>();

        for (int i = 0; i < listInquiry.size(); i++) {
            Inquiry inquiry = listInquiry.get(i);

            RecordInquiry recordInquiry = new RecordInquiry(
                    inquiry.getSeq(),
                    inquiry.getCategoryType(),
                    inquiry.getTitle(),
                    null,
                    inquiry.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            );

            listRecordInquiry.add(recordInquiry);
        }

        return listRecordInquiry;
    }

    public RecordInquiry getOne(Long seq) {
        Inquiry inquiry = inquiryRepository.findBySeq(seq).orElseThrow();

        return new RecordInquiry(
                inquiry.getSeq(),
                inquiry.getCategoryType(),
                inquiry.getTitle(),
                inquiry.getContent(),
                inquiry.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        );
    }

    public List<Inquiry> getAllList() {
        return inquiryRepository.findAll();
    }
}