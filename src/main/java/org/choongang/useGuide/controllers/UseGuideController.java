package org.choongang.useGuide.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("UseGuideController")
@RequestMapping("/notices")
@RequiredArgsConstructor
public class UseGuideController {

    @GetMapping("/useGuide")
    public String home() {
        return "front/notices/useGuide";
    }
}
