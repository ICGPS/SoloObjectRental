package org.choongang.main.controllers;

import lombok.RequiredArgsConstructor;
import org.choongang.commons.ExceptionProcessor;
import org.choongang.commons.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MainController implements ExceptionProcessor {

  private final Utils utils;

  @ModelAttribute("addCss")
  public String[] addCss() {

    return new String[] {"main/style"};
  }

  public String index() {

    return utils.tpl("main/index");
  }

}
