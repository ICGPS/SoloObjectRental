package org.choongang.member.service;

import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.choongang.commons.Utils;
import org.choongang.email.service.EmailMessage;
import org.choongang.email.service.EmailSendService;
import org.choongang.member.controllers.FindIdValidator;
import org.choongang.member.controllers.RequestFindId;
import org.choongang.member.repositories.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FindIdService {

    private final FindIdValidator validator;
    private final MemberRepository repository;
    private final EmailSendService sendService;
    private final Utils utils;

    public void process(RequestFindId form, Errors errors) {
        validator.validate(form, errors);
        // 유효성 검사 실패시에는 처리 중단
        if (errors.hasErrors()) {
            return;
        }

        // 아이디 재전송
        send(form.email());
    }

    public void send(String email) {
        EmailMessage emailMessage = new EmailMessage(email, Utils.getMessage("Email.id.find", "commons"), Utils.getMessage("Email.id.find", "commons"));
        Map<String, Object> tplData = new HashMap<>();
        tplData.get("id");
        sendService.sendMail(emailMessage, "id_send");
    }
}
