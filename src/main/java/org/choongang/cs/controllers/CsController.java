package org.choongang.cs.controllers;

import jakarta.servlet.http.HttpSession;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.choongang.commons.ExceptionProcessor;
import org.choongang.commons.Utils;
import org.choongang.cs.entities.FeedbackPost;
import org.choongang.cs.entities.Inquiry;
import org.choongang.cs.repositories.FeedbackPostRepository;
import org.choongang.cs.service.InquirySaveService;
import org.choongang.member.MemberUtil;
import org.choongang.member.controllers.RequestFindPw;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.entities.Member;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller("csController")
@RequestMapping("/cs")
@RequiredArgsConstructor
public class CsController implements ExceptionProcessor {
    private final MemberUtil memberUtil;
    private final Utils utils;
    private final InquirySaveService inquirySaveService;
    private final FeedbackPostRepository feedbackPostRepository;

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

        model.addAttribute("inquirySave", new InquirySave("add",null, null, null, null));

        if (memberUtil.isLogin()) {
            return utils.tpl("cs/inquiry_add");
        }

        return "redirect:/member/login";
    }

    @PostMapping("/inquirySave")
    public String inquirySave(@ModelAttribute InquirySave form, Errors errors, Model model) {
        commonProcess("inquirySave", model);

        inquirySaveService.save(form);

        return utils.tpl("cs/inquiry_add_done");
    }

    // 칭찬/개선
    @GetMapping("/feedbackPost")
    public String feedbackPost(Model model) {

        //String userName = principal.getName();

        commonProcess("feedbackPost", model);

        return utils.tpl("cs/feedbackPost");
    }

    @GetMapping("/feedbackPostAdd")
    public String feedbackPostAdd(Model model) {

        model.addAttribute("feedbackPost", new FeedbackPost());

        commonProcess("feedbackPostAdd", model);

        return utils.tpl("cs/feedbackPostAdd");
    }



    @PostMapping("/feedbackPostAdd")
    public String feedbackPostAddDone(
            @ModelAttribute FeedbackPost feedbackPost,
            @RequestParam("file") MultipartFile file, Principal principal) {

            String userName = principal.getName();
            feedbackPost.setAuthor(userName);

            if (!file.isEmpty()) {
                try {
                
                    String uploadDir = "C:/uploads/";
                    String fileName = file.getOriginalFilename();
                    String filePath = uploadDir + fileName;

                    File uploadDirFile = new File(uploadDir);
                    if (!uploadDirFile.exists()) {
                        uploadDirFile.mkdirs();
                    }
    
                    byte[] bytes = file.getBytes();
                    Path path = Paths.get(filePath);
                    Files.write(path, bytes);

                    feedbackPost.setFilePath(filePath);
                    
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("CsController - 파일 업로드 오류 발생");
                }
            } 

            feedbackPostRepository.save(feedbackPost);

            return utils.tpl("cs/feedbackPostAdd_done");

    }

    private void commonProcess(String mode, Model model) {
        mode = Objects.requireNonNullElse(mode, "index");
        String pageTitle = "고객지원";

        List<String> addCss = new ArrayList<>();

        if (mode.equals("inquiry") || mode.equals("inquiryAdd")) {
            pageTitle = mode.equals("inquiry") ? "1:1 문의" : "1:1 문의하기";

        } else if (mode.equals("feedbackPost") || mode.equals("feedbackPostAdd")) {
            pageTitle = mode.equals("feedbackPost") ? "칭찬/개선" : "의견보내기";
        }

        addCss.add("cs/cs");

        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("addCss", addCss);

    }
}
