package org.choongang.cs.controllers;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.choongang.commons.ExceptionProcessor;
import org.choongang.commons.Utils;
import org.choongang.cs.entities.Inquiry;
import org.choongang.cs.service.InquirySaveService;
import org.choongang.member.MemberUtil;
import org.choongang.member.controllers.RequestFindPw;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.entities.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller("csController")
@RequestMapping("/cs")
@RequiredArgsConstructor
public class CsController implements ExceptionProcessor {
    private final MemberUtil memberUtil;
    private final Utils utils;
    private final InquirySaveService inquirySaveService;

    // 고객지원 홈
    @GetMapping("/main")
    public String index(Model model) {
        commonProcess("index", model);

        return utils.tpl("cs/index");
    }

    // 1:1 문의
    @GetMapping("/inquiry")
    public String inquiry(Model model) {
        commonProcess("inquiry", model);

        return utils.tpl("cs/inquiry");
    }

    @GetMapping("/inquiryAdd")
    public String inquiryAdd(Model model) {
        commonProcess("inquiryAdd", model);

        model.addAttribute("inquirySave", new InquirySave("add",null, null, null, null));

        if (memberUtil.isLogin()) {
            return utils.tpl("cs/inquiry_add");
        }

        return "redirect:/member/login";
    }

    @PostMapping("/inquirySave")
    public String inquirySave(@ModelAttribute InquirySave form, Errors errors, Model model) {
        commonProcess("inquirySave", model);

        inquirySaveService.save(form);

        return utils.tpl("cs/inquiry_add_done");
    }

    @GetMapping("/inquiryList")
    public String inquiryList(Model model) {
        commonProcess("inquiryList", model);

        return utils.tpl("cs/inquiry_list");
    }

    // 칭찬/개선
    @GetMapping("/feedbackPost")
    public String feedbackPost(Model model) {
        commonProcess("feedbackPost", model);

        return utils.tpl("cs/feedbackPost");
    }

    @GetMapping("/feedbackPostAdd")
    public String feedbackPostAdd(Model model) {
        commonProcess("feedbackPostAdd", model);

        return utils.tpl("cs/feedbackPost_add");
    }

    private void commonProcess(String mode, Model model) {
        mode = Objects.requireNonNullElse(mode, "index");
        String pageTitle = "고객지원";

        List<String> addCss = new ArrayList<>();

        if (mode.equals("inquiry") || mode.equals("inquiryAdd")) {
            pageTitle = mode.equals("inquiry") ? "1:1 문의" : "1:1 문의하기";

        } else if (mode.equals("feedbackPost") || mode.equals("feedbackPostAdd")) {
            pageTitle = mode.equals("feedbackPost") ? "칭찬/개선" : "의견보내기";
        }

        addCss.add("cs/cs");

        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("addCss", addCss);

    }
}
