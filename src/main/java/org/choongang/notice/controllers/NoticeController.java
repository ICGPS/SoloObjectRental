package org.choongang.notice.controllers;

import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.choongang.notice.entities.Notice;
import org.choongang.notice.repositories.NoticeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller("NoticeController")
@RequestMapping("/notices")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeRepository noticeRepository;

    @GetMapping("/index")
    public String Notices(Model model) {
        // localhost:3000/notices/index

        // DB에서 공지사항 가져오기
        List<Notice> notices = noticeRepository.findAll();

        model.addAttribute("notices", notices);

        return "front/notices/index";
    }

    @GetMapping("/new")
    public String newNotice(Model model) {

        model.addAttribute("notice", new Notice());
        return "front/notices/newNotice";
    }


    @PostMapping("/new")
    public String newNotice(@ModelAttribute("notice") Notice notice) {
        // 현재 날짜로 생성일을 설정
        notice.setCreatedAt(new Date());

        // 공지사항을 DB에 저장
        noticeRepository.save(notice);

        // 새로운 공지사항을 추가한 후, "/notices/index" 페이지로
        return "redirect:/notices/index";
    }


    @GetMapping("/{id}")
    public String getNoticeById(@PathVariable(name = "id") Long id, Model model) {
        Notice notice = noticeRepository.findById(id).orElse(null);

        if (notice == null) { // 공지사항이 없을 경우 에러 페이지로 이동
            return "error";
        }

        model.addAttribute("notice", notice);

        return "front/notices/noticeDetail";
    }
}