package org.choongang.mypage.controller;

import lombok.RequiredArgsConstructor;
import org.choongang.commons.validators.PasswordValidator;
import org.choongang.member.repositories.MemberRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class MemberInfoValidator implements Validator, PasswordValidator {

    private final MemberRepository memberUpdateRepository;
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(requestUpdateMemberInfo.class);
    }

    @Override
    public void validate(Object target, Errors errors) {

        /**
         * 1. 기존 비밀번호, 새 비밀번호 중복 여부 체크
         * 2. 비밀번호 복잡성 체크 - 대소문자 1개 각각 포함, 숫자 1개 이상 포함, 특수문자도 1개 이상 포함
         * 3. 비밀번호, 비밀번호 확인 일치 여부 체크
         */
        requestUpdateMemberInfo form = (requestUpdateMemberInfo)target;
        String password = form.getPassword();
        String newPassword = form.getNewPassword();
        String newConfirmPassword = form.getNewConfirmPassword();

        // 1. 기존 비밀번호, 새 비밀번호  중복 여부 체크
        if (StringUtils.hasText(newPassword) && memberUpdateRepository.existsByEmail(password)) {
            errors.rejectValue("email", "Duplicated");
        }

        // 2. 새 비밀번호 복잡성 체크 - 대소문자 1개 각각 포함, 숫자 1개 이상 포함, 특수문자도 1개 이상 포함
        if (StringUtils.hasText(newPassword) &&
                (!alphaCheck(newPassword, true) || !numberCheck(newPassword) || !specialCharsCheck(newPassword))) {
            errors.rejectValue("password", "Complexity");
        }

        // 3. 비밀번호, 비밀번호 확인 일치 여부 체크
        if (StringUtils.hasText(newPassword) && StringUtils.hasText(newConfirmPassword)
                && !password.equals(newConfirmPassword)) {
            errors.rejectValue("newConfirmPassword", "Mismatch.newPassword");
        }
    }
}
