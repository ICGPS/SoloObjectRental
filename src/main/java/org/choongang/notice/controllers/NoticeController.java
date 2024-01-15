package org.choongang.notice.controllers;

import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.choongang.notice.entities.Notice;
import org.choongang.notice.repositories.NoticeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller("NoticeController")
@RequestMapping("/notices")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeRepository noticeRepository;

    @GetMapping
    public String Notices(Model model) {

        // DB에서 공지사항 가져오기
        List<Notice> notices = noticeRepository.findAll();

        model.addAttribute("notices", notices);

        return "index";
    }

    @GetMapping("/notices/new")
    public String NoticeForm(Model model) {
        System.out.println("공지사항 게시판으로 이동");

        model.addAttribute("notice", new Notice());
        return "noticeForm";
    }

    @PostMapping("/notices/new")
    public String newNotice(Notice notice) {
        System.out.println("");

        // 현재 날짜로 작성일 설정
        notice.setCreatedAt(new Date());

        // 공지사항을 DB에 저장
        noticeRepository.save(notice);

        // "/notice"
        return "redirect:/notices/index";
    }

    @GetMapping("/notices/{id}")
    public String getNoticeById(@PathVariable Long id, Model model) {
        Notice notice = noticeRepository.findById(id).orElse(null);

        if (notice == null) { // 공지사항이 없을 경우 에러 페이지로 이동
            return "error";
        }

        model.addAttribute("notice", notice);

        return "noticeDetail";
    }
}






















