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

@Controller("csController")
@RequestMapping("/cs")
@RequiredArgsConstructor
public class CsController implements ExceptionProcessor {
    private final Utils utils;

    // 고객지원 홈
    @GetMapping("/index")
    public String index() {

        System.out.println("cs화면 테스트");

        return utils.tpl("cs/index");
    }

    // 1:1 문의
    @GetMapping("/inquiry")
    public String inquiry() {

        return utils.tpl("cs/inquiry");
    }

    @GetMapping("/inquiryAdd")
    public String inquiryAdd() {

        return utils.tpl("cs/inquiry_add");
    }

    // 칭찬/개선
    @GetMapping("/improvement")
    public String improvement() {

        return utils.tpl("cs/improvement");
    }

}
