package org.choongang.mypage.controller;

import lombok.RequiredArgsConstructor;
import org.choongang.commons.ExceptionProcessor;
import org.choongang.member.MemberUtil;
import org.choongang.member.entities.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class mypageController implements ExceptionProcessor {


    private final MemberUtil memberUtil;

    @GetMapping
    public String myPage() {

        System.out.println("마이페이지");

        return "front/mypage/main";
    }
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

        System.out.println("주문 상세 페이지(주문 목록에서 상품 클릭 시 뜨는 창)");

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
    public String lentalList(Model model){
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
        commonProcess("memberInfo");
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

    private void commonProcess(String mode) {
//        list<> addcss
//        if(mode.equals("memberInfo")) {
//            adcss.("/static/mypage/css/memberInfo");
//        } else (eq(aaa) {
//            addcss()
//        }
    }

}
