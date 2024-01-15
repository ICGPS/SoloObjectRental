package org.choongang.cs.controllers;

import lombok.RequiredArgsConstructor;
import org.choongang.commons.ExceptionProcessor;
import org.choongang.commons.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller("csController")
@RequestMapping("/cs")
@RequiredArgsConstructor
public class CsController implements ExceptionProcessor {
    private final Utils utils;

    // 고객지원 홈
    @GetMapping("/main")
    public String index(Model model) {
        commonProcess("index", model);

        System.out.println("cs화면 테스트");

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

        return utils.tpl("cs/inquiry_add");
    }

    // 칭찬/개선
    @GetMapping("/feedbackPost")
    public String improvement(Model model) {
        commonProcess("feedbackPost", model);

        return utils.tpl("cs/feedbackPost");
    }

    private void commonProcess(String mode, Model model) {
        mode = Objects.requireNonNullElse(mode, "index");
        String pageTitle = "고객지원";

        List<String> addCss = new ArrayList<>();

        if (mode.equals("inquiry") || mode.equals("inquiryAdd")) {
            pageTitle = mode.equals("inquiry") ? "1:1 문의" : "1:1 문의 작성";

        } else if (mode.equals("feedbackPost")) {
            pageTitle = "칭찬/개선";
        }

        addCss.add("cs/cs");

        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("addCss", addCss);

    }
}
