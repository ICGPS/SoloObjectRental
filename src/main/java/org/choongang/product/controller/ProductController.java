//package org.choongang.product.controller;
//
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.choongang.admin.product.controllers.RequestProduct;
//import org.choongang.commons.ExceptionProcessor;
//import org.choongang.commons.Utils;
//import org.choongang.member.MemberUtil;
//import org.choongang.product.service.ProductSaveService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller("productController")
//@RequestMapping("/product")
//@RequiredArgsConstructor
//public class ProductController implements ExceptionProcessor {
//
//    private final Utils utils;
//    private final MemberUtil memberUtil;
//    private final ProductSaveService productSaveService;
//
//
//    @GetMapping("/index")
//    public String index() {
//
//        System.out.println("index페이지로~");    // 확인용
//        return utils.tpl("product/index");
//    }
//
//    // /list 뒤에 카테고리명 or 코드로 카테고리별 페이지 갈 수 있도록
//    @GetMapping("/list")
//    public String list() {
//        System.out.println("list페이지로~");    // 확인용
//        return utils.tpl("product/list");
//    }
//
//    @GetMapping("/info")
//    public String listInfo() {
//        System.out.println("info페이지로~");    // 확인용
//        return utils.tpl("product/info");
//
//    }
//
//    @PostMapping("order")
//    public String order() {
//        System.out.println("주문페이지로");
//        // 로그인 상태 확인
//        if (memberUtil.isLogin()) {
//            return utils.tpl("product/order");
//        } else {
//            return "redirect:/member/login";
//        }
//
//    }
//
//    /**
//     * 상품 등록, 수정 처리
//     *
//     * @param model
//     * @return
//     */
////    @PostMapping("/save")
////    public String save(@Valid RequestProduct form, Errors errors, Model model) {
////        String mode = form.getMode();
////        commonProcess(mode, model);
////
////        if (errors.hasErrors()) {
////            return "admin/product/" + mode;
////        }
////
////        productSaveService.save(form);
////
////        return "redirect:/admin/product";
////    }
//}
