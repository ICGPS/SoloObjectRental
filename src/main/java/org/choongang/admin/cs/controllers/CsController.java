package org.choongang.admin.cs.controllers;

import lombok.RequiredArgsConstructor;
import org.choongang.admin.cs.service.InquiryAnswerService;
import org.choongang.admin.menus.Menu;
import org.choongang.admin.menus.MenuDetail;
import org.choongang.cs.controllers.RecordInquiry;
import org.choongang.cs.entities.FeedbackPost;
import org.choongang.cs.entities.Inquiry;
import org.choongang.cs.entities.InquiryAnswer;
import org.choongang.cs.service.FeedbackService;
import org.choongang.cs.service.InquiryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller("adminCsController")
@RequestMapping("admin/cs")
@RequiredArgsConstructor
public class CsController {
    private final InquiryService inquiryService;
    private final InquiryAnswerService inquiryAnswerService;
    private final FeedbackService feedbackService;

    @ModelAttribute("menuCode")
    public String getMenuCode() { // 주 메뉴 코드
        return "cs";
    }

    @ModelAttribute("subMenus")
    public List<MenuDetail> getSubMenus() {
        return Menu.getMenus("cs");
    }

    // 1:1 문의
    @GetMapping
    public String inquiry(Model model) {
        commonProcess("inquiry", model);

        List<Inquiry> inquiryList = inquiryService.getAllList();
        model.addAttribute("inquiryList", inquiryList);

        return "admin/cs/inquiry_list";
    }

    @GetMapping("/adminInquiryDetail/{seq}")
    public String inquiryDetail(@PathVariable("seq") Long seq, Model model) {
        commonProcess("inquiry", model);

        RecordInquiry recordInquiry = inquiryService.getOne(seq);
        model.addAttribute("recordInquiry", recordInquiry);

        InquiryAnswer inquiryAnswer = inquiryAnswerService.getOne(seq);
        model.addAttribute("inquiryAnswer", inquiryAnswer);

        return "admin/cs/inquiry_detail";
    }

    @PostMapping("/adminInquiryAnswerSave")
    public String inquiryDetail(@ModelAttribute InquiryAnswer form, Model model) {
        commonProcess("inquiry", model);

        inquiryAnswerService.save(form);

        RecordInquiry recordInquiry = inquiryService.getOne(form.getInquirySeq());
        model.addAttribute("recordInquiry", recordInquiry);

        return "admin/cs/inquiry_detail";
    }

    // 상품 문의
    @GetMapping("/product")
    public String product(Model model) {
        commonProcess("product", model);

        return "admin/cs/product_inquiry";
    }

    // 칭찬/개선
    @GetMapping("/feedback")
    public String feedback(Model model) {
        commonProcess("feedback", model);

        List<FeedbackPost> feedbackPost = feedbackService.getAllList();
        model.addAttribute("feedbackPost", feedbackPost);

        return "admin/cs/feedback";
    }

    private void commonProcess(String mode, Model model) {
        mode = Objects.requireNonNullElse(mode, "cs");
        String pageTitle = "CS";

        model.addAttribute("subMenuCode", mode);
        model.addAttribute("pageTitle", pageTitle);
    }
}