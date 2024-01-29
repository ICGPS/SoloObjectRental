package org.choongang.mypage.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.choongang.commons.ExceptionProcessor;
import org.choongang.commons.Utils;
import org.choongang.email.service.EmailVerifyService;
import org.choongang.file.entities.FileInfo;
import org.choongang.file.service.FileInfoService;
import org.choongang.member.MemberUtil;
import org.choongang.member.entities.Member;
import org.choongang.member.service.MemberUpdateService;
import org.choongang.mypage.service.ResignService;
import org.springframework.security.access.prepost.PreAuthorize;
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

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MypageController implements ExceptionProcessor {

    private final FileInfoService fileInfoService;
    private final Utils utils;
    private final MemberUtil memberUtil;
    private final MemberUpdateService memberUpdateService;
    private final ProfileValidator profileValidator;

    private final ResignValidator resignValidator;
    private final ResignService resignService;

    private final EmailVerifyService emailVerifyService;

    @GetMapping
    public String myPage(Model model) {

        commonProcess("main", model);

        return utils.tpl("mypage/index");
    }


    @GetMapping("/profile")
    public String profile(@ModelAttribute RequestProfile form, Model model) {
        commonProcess("profile", model);

        Member member = memberUtil.getMember();
        form.setName(member.getName());
        form.setPassword(member.getPassword());
        form.setConfirmPassword(member.getPassword());

        return utils.tpl("mypage/profile");
    }

    @PostMapping("/profile")
    public String updateProfile(@Valid RequestProfile form, Errors errors, Model model) {
        commonProcess("profile", model);

        profileValidator.validate(form, errors);

        if (errors.hasErrors()) {

            String gid = memberUtil.getMember().getGid();

            return utils.tpl("mypage/profile");
        }
        memberUpdateService.update(form);

        return "redirect:/mypage";
    }


    //
    //    @GetMapping
    //    public String myPage() {
    //
    //        System.out.println("마이페이지");
    //
    //        return "front/mypage/main";
    //    }
    //    @GetMapping("/mypage/main")
    //    public String myPage(Model model) {
    //        commonProcess("myPage",model);
    //
    //        System.out.println("마이페이지");
    //
    //        return utils.tpl("mypage/main");
    //    }


    // 주문 상세 페이지 연결 추가 S //
    @GetMapping("/orderDetail")
    public String orderDetail(Model model) {

        return "front/mypage/orderDetail";
    }
    // 주문 상세 페이지 연결 추가 E //


    // 장바구니 결제 페이지 추가 S //
    @GetMapping("/orderInCart")
    public String orderInCart(Model model) {

        System.out.println("장바구니 결제 페이지");

        return "front/mypage/orderInCart";

    }
    // 장바구니 결제 페이지 추가 E //

    // 결제 완료 페이지 추가 S //
    @GetMapping("/paymentFinish")
    public String paymentFinish(Model model) {

        System.out.println("결제 완료 페이지");

        return "front/mypage/paymentFinish";

    }
    // 결제 완료 페이지 추가 E //

    // 구매 영수증 추가 S //
    @GetMapping("/purchaseReceipt")
    public String purchaseReceipt(Model model) {

        System.out.println("구매 영수증 페이지");

        return "front/mypage/purchaseReceipt";

    }
    // 구매 영수증 추가 E //

    //    @GetMapping("/memberInfo")
    //    public String memberInfo(Model model) {
    ////        commonProcess("memberInfo",model);
    //
    //        System.out.println("회원정보,수정");
    //
    ////        return utils.tpl("mypage/memberInfo");
    //        return "front/mypage/memberInfo";
    //    }

    @GetMapping("/deliveryAddressList")
    public String deliveryAddressList(Model model) {
        //        commonProcess("deliveryAddressList",model);

        System.out.println("배송지관리");

        //        return utils.tpl("mypage/deliveryAddressList");
        return "front/mypage/deliveryAddressList";
    }

    @GetMapping("/paymentList")
    public String paymentList(Model model) {
        //        commonProcess("paymentList",model);

        System.out.println("결제관리");

        //        return utils.tpl("mypage/paymentList");
        return "front/mypage/paymentList";
    }

    @GetMapping("/lentalList")
    public String lentalList(Model model) {
        return "front/mypage/lentalList";
    }

    @GetMapping("deliverAddressList")
    public String deliverAddressList(Model model) {
        return "front/mypage/deliverAddressList";
    }


    /*@GetMapping("/memberInfo")
    public String getMemberInfo(Model model) {
        // 회원 정보를 모델에 추가
        // model.addAttribute("memberInfo", memberInfo); // memberInfo는 실제로 사용하는 데이터 객체
        return "front/mypage/memberInfo";
    }
*/

    @GetMapping("/memberInfo")
    public String updateMemberInfo(@ModelAttribute MemberInfoForm memberInfoForm, Model model) {
        // 회원 정보 수정 로직 추가
        commonProcess("memberInfo", model);
        Member member = (Member) memberUtil.getMember();
        if (memberUtil.isLogin()) {
            System.out.println(member);
            model.addAttribute("member", member);

            return "front/mypage/memberInfo";
        } else {
            return "redirect:/mypage";
        }

        //        return "redirect:/mypage/memberInfo";
    }

    @PostMapping("/updateMemberInfo")
    public String updateMemberInfoPs(@ModelAttribute MemberInfoForm memberInfoForm, Model model) {
        // 회원 정보 수정 로직 추가


        //        model.addAttribute(member.get);
        //        updateMemberInfoService.process(MemberInfoForm, errors);
        //        if (errors.hasErrors()) {
        //            return "redirect:/mypage/memberInfo";
        //        }
        return "redirect:/mypage/memberInfo";
    }

    @GetMapping("/resign")
    public String resignStep1(@ModelAttribute RequestResign form, Model model) {
        commonProcess("resign", model);

        return utils.tpl("mypage/resign");
    }

    // 이메일로 전송된 코드 확인
    @PostMapping("/resign")
    public String resignStep2(RequestResign form, Errors errors, Model model) {
        commonProcess("resign", model); // 비밀번호, 비밀번호 확인

        form.setMode("step1");
        resignValidator.validate(form, errors);

        if (errors.hasErrors()) {
            return utils.tpl("mypage/resign");
        }
        
        // 메일로 인증 코드 발송
        emailVerifyService.sendCode(memberUtil.getMember().getEmail());

        return utils.tpl("mypage/resign_auth");
    }

    /**
     * 회원탈퇴 완료
     *          enable -> false, 로그아웃 -> 비회원도 접근 가능
     * @param model
     * @return
     */
    @PostMapping("/resign_done")

    public String resignProcess(RequestResign form, Errors errors, Model model) {
        commonProcess("resign", model); // 인증번호 여부

        form.setMode("step2");
        resignValidator.validate(form, errors);

        if (errors.hasErrors()) { // 인증 코드 실패시
            return utils.tpl("mypage/resign_auth");
        }

        // 회원 탈퇴 처리
        resignService.resign();

        return "redirect:/mypage/resign_done";
    }

    @GetMapping("/resign_done")
    @PreAuthorize("permitAll()")
    public String resignDone(Model model) {
        commonProcess("resign", model);

        return utils.tpl("mypage/resign_auth");
    }

    private void commonProcess(String mode, Model model) {
        mode = StringUtils.hasText(mode) ? mode : "main";
        String pageTitle = Utils.getMessage("마이페이지", "commons");

        List<String> addCss = new ArrayList<>();
        List<String> addScript = new ArrayList<>();
        List<String> addCommonScript = new ArrayList<>();

        if (mode.equals("profile")) {
            pageTitle = Utils.getMessage("회원정보_수정", "commons");
            addCommonScript.add("fileManager");
            addScript.add("mypage/profile");

        } else if (mode.equals("resign")) {
            pageTitle = Utils.getMessage("회원_탈퇴", "commons");
        }

        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("addCss", addCss);
        model.addAttribute("addScript", addScript);
        model.addAttribute("addCommonScript", addCommonScript);

    }
}