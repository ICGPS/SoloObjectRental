package org.choongang.cs.controllers;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.choongang.admin.cs.service.InquiryAnswerService;
import org.choongang.board.entities.BoardData;
import org.choongang.board.service.BoardInfoService;
import org.choongang.commons.ExceptionProcessor;
import org.choongang.commons.Utils;
import org.choongang.cs.entities.FeedbackPost;
import org.choongang.cs.entities.InquiryAnswer;
import org.choongang.cs.repositories.FeedbackPostRepository;
import org.choongang.cs.service.FeedbackService;
import org.choongang.cs.service.InquiryService;
import org.choongang.file.service.FileUploadService;
import org.choongang.member.MemberUtil;
import org.choongang.member.entities.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private final InquiryService inquiryService;
    private final InquiryAnswerService inquiryAnswerService;
    private final FeedbackPostRepository feedbackPostRepository;
    private final BoardInfoService boardInfoService;
    private final FileUploadService fileUploadService;

    // 고객지원 홈
    @GetMapping("/main")
    public String index(Model model) {
        commonProcess("index", model);

        return utils.tpl("cs/index");
    }

    // 1:1 문의
    @GetMapping("/inquiry")
    public String inquiry(Model model) {
        commonProcess("inquiry", model);

        List<BoardData> items = boardInfoService.getLatest("qna");
        model.addAttribute("items", items);

        return utils.tpl("cs/inquiry");
    }

    @GetMapping("/inquiryAdd")
    public String inquiryAdd(Model model) {
        commonProcess("inquiryAdd", model);

        model.addAttribute("inquirySave", new InquirySave("add", null, null, null, null));

        if (memberUtil.isLogin()) {
            return utils.tpl("cs/inquiry_add");
        }

        return "redirect:/member/login";
    }

    @PostMapping("/inquirySave")
    public String inquirySave(@ModelAttribute InquirySave form, Errors errors, Model model) {
        commonProcess("inquirySave", model);

        inquiryService.save(form);

        return utils.tpl("cs/inquiry_add_done");
    }

    @GetMapping("/inquiryList")
    public String inquiryList(Model model) {
        commonProcess("inquiryList", model);

        List<RecordInquiry> listRecordInquiry = inquiryService.getList();
        model.addAttribute("listRecordInquiry", listRecordInquiry);

        return utils.tpl("cs/inquiry_list");
    }

    @GetMapping("/inquiryDetail/{seq}")
    public String inquiryDetail(@PathVariable("seq") Long seq, Model model) {
        commonProcess("inquiryDetail", model);

        RecordInquiry recordInquiry = inquiryService.getOne(seq);
        model.addAttribute("recordInquiry", recordInquiry);

        InquiryAnswer inquiryAnswer = inquiryAnswerService.getOne(seq);
        model.addAttribute("inquiryAnswer", inquiryAnswer);

        return utils.tpl("cs/inquiry_detail");
    }


    // 칭찬/개선
    @GetMapping("/feedbackPost")
    public String feedbackPost(Model model) {
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
    public String FeedbackPostAdd(@ModelAttribute("feedbackPost") FeedbackPost feedbackPost, Model model/* @RequestParam("file") MultipartFile file, Principal principal */) {
        commonProcess("feedbackPost", model);

        /*
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


                feedbackPost.setImageUrl("C:/uploads/" + fileName);

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("CsController - 파일 업로드 오류 발생");

            }
        }
        */

        Member member = memberUtil.getMember();
        feedbackPost.setAuthor(member.getName());

        // feedbackPost 저장
        feedbackPostRepository.save(feedbackPost);
        fileUploadService.processDone(feedbackPost.getGid());

        return utils.tpl("cs/feedbackPostAdd_done");
    }

    private void commonProcess(String mode, Model model) {
        mode = Objects.requireNonNullElse(mode, "index");
        String pageTitle = "고객지원";

        List<String> addCss = new ArrayList<>();
        List<String> addCommonScript = new ArrayList<>();

        if (mode.equals("inquiry") || mode.equals("inquiryAdd")) {
            pageTitle = mode.equals("inquiry") ? "1:1 문의" : "1:1 문의하기";

        } else if (mode.equals("feedbackPost") || mode.equals("feedbackPostAdd")) {
            pageTitle = mode.equals("feedbackPost") ? "칭찬/개선" : "의견보내기";

        }

        addCss.add("cs/cs");
        addCommonScript.add("fileManager");

        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("addCss", addCss);
        model.addAttribute("addCommonScript", addCommonScript);

    }
}
