package org.choongang.mypage.controller;

import lombok.RequiredArgsConstructor;
import org.choongang.commons.ExceptionProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class mypageController implements ExceptionProcessor {

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
    @GetMapping("/productDetail")
    public String productDetail(Model model) {

        System.out.println("주문 상세 페이지(주문 목록에서 상품 클릭 시 뜨는 창)");

        return "front/mypage/productDetail";
    }
    // 주문 상세 페이지 연결 추가 E //

    // 장바구니 결제 페이지 S //
    @GetMapping("/orderInCart")
    public String orderInCart(Model model) {

        System.out.println("장바구니 결제 페이지");

        return "front/mypage/orderInCart";

    }
    // 장바구니 결제 페이지 E //

    // 결제 완료 페이지 S //
    @GetMapping("/paymentFinish")
    public String paymentFinish(Model model) {

        System.out.println("결제 완료 페이지");

        return "front/mypage/paymentFinish";

    }
    // 결제 완료 페이지 E //

    @GetMapping("/memberInfo")
    public String memberInfo(Model model) {
//        commonProcess("memberInfo",model);

        System.out.println("회원정보,수정");

//        return utils.tpl("mypage/memberInfo");
        return "front/mypage/memberInfo";
    }

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


}
