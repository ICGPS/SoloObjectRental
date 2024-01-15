package org.choongang.member.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.choongang.commons.ExceptionProcessor;
import org.choongang.commons.Utils;
import org.choongang.member.service.JoinService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@SessionAttributes("EmailAuthVerified")
public class MemberController implements ExceptionProcessor {

    private final Utils utils;
    private final JoinService joinService;

    @GetMapping("/join")
    public String join(@ModelAttribute RequestJoin form, Model model) {
        commonProcess("join", model);

        // 이메일 인증 여부 false로 초기화
        model.addAttribute("EmailAuthVerified", false);

        return utils.tpl("member/join");
    }

    @PostMapping("/join")
    public String joinPs(@Valid RequestJoin form, Errors errors,Model model, SessionStatus sessionStatus) {
        commonProcess("join", model);

        joinService.process(form, errors);

        if (errors.hasErrors()) {
            return utils.tpl("member/join");
        }

        // EmailAuthVerified 세션값 비우기 */
        sessionStatus.setComplete();

        return "redirect:/member/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        commonProcess("login", model);

        return utils.tpl("member/login");
    }

    @GetMapping("/findId")
    public String findId(Model model) {
        commonProcess("findId", model);

        System.out.println("아이디 찾기 테스트");

        return utils.tpl("member/findId");
    }

    @GetMapping("/findPw")
    public String findPw(Model model) {
        commonProcess("findPw", model);

        System.out.println("비밀번호 찾기 테스트");

        return utils.tpl("member/findPw");
    }

    @GetMapping("/mainPage")
    public String mainPage(Model model) {
        commonProcess("mainPage", model);

        System.out.println("메인페이지 테스트");

        return utils.tpl("member/mainPage");
    }


    private void commonProcess(String mode, Model model) {
        mode = StringUtils.hasText(mode) ? mode : "join";
        String pageTitle = Utils.getMessage("회원가입", "commons");

        List<String> addCss = new ArrayList<>();
        List<String> addScript = new ArrayList<>();
        List<String> addCommonScript = new ArrayList<>();

        if (mode.equals("login")) { // 로그인
            pageTitle = Utils.getMessage("로그인", "commons");

        } else if (mode.equals("join")) { // 회원가입
            addCss.add("member/join");
            addScript.add("member/join");
            addCommonScript.add("address");

        } else if (mode.equals("find_pw")) { // 비밀번호 찾기
            pageTitle = Utils.getMessage("비밀번호_찾기", "commons");
        }

        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("addCss", addCss);
        model.addAttribute("addScript", addScript);
        model.addAttribute("addCommonScript", addCommonScript);

    }

    @GetMapping("/myPage")
    public String myPage(Model model) {
        commonProcess("myPage",model);

        System.out.println("마이페이지");

        return utils.tpl("mypage/main");
    }

    @GetMapping("memberInfo")
    public String memberInfo(Model model) {
        commonProcess("memberInfo",model);

        System.out.println("회원정보,수정");

        return utils.tpl("member/memberInfo");
    }

    @GetMapping("deliveryAddressList")
    public String deliveryAddressList(Model model) {
        commonProcess("deliveryAddressList",model);

        System.out.println("배송지관리");

        return utils.tpl("member/deliveryAddressList");
    }

    @GetMapping("paymentList")
    public String paymentList(Model model) {
        commonProcess("paymentList",model);

        System.out.println("결제관리");

        return utils.tpl("member/paymentList");
    }

}