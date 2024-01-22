package org.choongang.product.controllers;

import lombok.RequiredArgsConstructor;
import org.choongang.product.entities.Category;
import org.choongang.product.service.CategoryInfoService;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice("org.choongang")
@RequiredArgsConstructor
public class ProductAdvice {
    private final CategoryInfoService categoryInfoService;

    /**
     * 상품 분류는 사용자 페이지 전역에 유지 되므로 전역 속성으로 정의
     * @return
     */
    @ModelAttribute("categories")
    private List<Category> getCategories() {

//        List<Category> categories = new ArrayList<>();
//        categories.add(new Category("01", "가구", 0, true));
//        categories.add(new Category("02", "전자", 0, true));

        return categoryInfoService.getList();
    }

}
