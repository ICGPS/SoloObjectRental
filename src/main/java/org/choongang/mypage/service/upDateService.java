package org.choongang.mypage.service;

import lombok.RequiredArgsConstructor;
import org.choongang.member.Authority;
import org.choongang.member.entities.Authorities;
import org.choongang.member.entities.Member;
import org.choongang.member.repositories.AuthoritiesRepository;
import org.choongang.member.repositories.MemberRepository;
import org.choongang.mypage.controller.MemberInfoValidator;
import org.choongang.mypage.controller.requestUpdateMemberInfo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;


@Service
@RequiredArgsConstructor
@Transactional
public class upDateService {
    private final MemberRepository upDateRepository;
    private final AuthoritiesRepository authoritiesRepositoryUpdate;
    private final MemberInfoValidator memberInfoValidator;
    private final PasswordEncoder upDateCoder;


    public void process(requestUpdateMemberInfo form, Errors errors) {
        memberInfoValidator.validate(form, errors);
        if (errors.hasErrors()) {
            return;
        }
    }
//    // 비밀번호 BCrypt로 해시화
//    String hash = upDateCoder.upDateCoder(form.getPassword());
//
//        //Member member = new ModelMapper().map(form, Member.class);
//        Member member = new Member();

//            member.setPassword(hash);
//            member.setUserName(form.getUserName());
//            member.setTel(form.getTel());
//            member.setAddress((form.getAddress()));
//    //        member.setNation(form.getNation());
//
//        process(member);
//
//
//    }
//
//public void process(Member member) {
//    memberRepository.saveAndFlush(member);
//}

}
