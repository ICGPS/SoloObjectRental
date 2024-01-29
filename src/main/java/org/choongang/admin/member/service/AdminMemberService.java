package org.choongang.admin.member.service;

import lombok.RequiredArgsConstructor;
import org.choongang.commons.ListData;
import org.choongang.commons.Utils;
import org.choongang.commons.exceptions.AlertException;
import org.choongang.member.Authority;
import org.choongang.member.controllers.MemberSearch;
import org.choongang.member.entities.Authorities;
import org.choongang.member.entities.Member;
import org.choongang.member.repositories.AuthoritiesRepository;
import org.choongang.member.repositories.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminMemberService {

    private final MemberRepository memberRepository;
    private final AuthoritiesRepository authoritiesRepository;
    private final Utils utils;

    public void saveList(List<Long> chks) {
        if (chks == null || chks.isEmpty()) {
            throw new AlertException("수정할 회원을 선택하세요.", HttpStatus.BAD_REQUEST);
        }

        for (Long chk : chks) {
            String seq = utils.getParam("seq_" + chk);
            Member member = memberRepository.findById(Long.valueOf(seq)).orElse(null);
            if (member == null) continue;

            Authorities authorities = member.getAuthorities().stream()
                    .filter(auth -> auth.getMember().equals(member))
                    .findFirst()
                    .orElse(new Authorities());

            System.out.println("before: " + authorities);

            String authorityValue = utils.getParam("authority_" + seq);

            authorities.setAuthority(Authority.valueOf(authorityValue));

            authoritiesRepository.saveAndFlush(authorities);
//            member.getAuthorities().add(authorities);
            System.out.println("after: " + authorities);
        }
    }
}
