 package org.choongang.product.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.choongang.admin.product.controllers.RequestProduct;
import org.choongang.commons.ExceptionProcessor;
import org.choongang.commons.Utils;
import org.choongang.member.MemberUtil;
import org.choongang.product.service.ProductSaveService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

 @Controller("productController")
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController implements ExceptionProcessor {

    private final Utils utils;
    private final MemberUtil memberUtil;
    private final ProductSaveService productSaveService;


    @GetMapping("/index")
    public String index() {

        return utils.tpl("product/index");
    }

    // /list 뒤에 카테고리명 or 코드로 카테고리별 페이지 갈 수 있도록
    @GetMapping("/list")
    public String list() {

        return utils.tpl("product/list");
    }

    @GetMapping("/info")
    public String listInfo(Model model) {

//        commonProcess("info", model);
        return utils.tpl("product/info");

    }

    @PostMapping("order")
    public String order() {
        System.out.println("주문페이지로");
        // 로그인 상태 확인
        if (memberUtil.isLogin()) {
            return utils.tpl("product/order");
        } else {
            return "redirect:/member/login";
        }

    }

    private void commonProcess(String mode, Model model) {
        String pageTitle = "상품 메인";
        mode = StringUtils.hasText(mode) ? mode : "main";

        if (mode.equals("list")) {
            pageTitle = "상품 목록";
        } else if (mode.equals("info")) {
            pageTitle = "상품 상세";
        } else if (mode.equals("order")) {
            pageTitle = "제품 주문";
        }

        List<String> addCommonScript = new ArrayList<>();
        List<String> addScript = new ArrayList<>();

        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("addCommonScript", addCommonScript);
        model.addAttribute("addScript", addScript);
    }
    /**
     * 상품 등록, 수정 처리
     *
     * @param model
     * @return
     */
//    @PostMapping("/save")
//    public String save(@Valid RequestProduct form, Errors errors, Model model) {
//        String mode = form.getMode();
//        commonProcess(mode, model);
//
//        if (errors.hasErrors()) {
//            return "admin/product/" + mode;
//        }
//
//        productSaveService.save(form);
//
//        return "redirect:/admin/product";
//    }
}
