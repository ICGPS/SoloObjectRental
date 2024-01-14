package org.choongang.orderDetails;

import lombok.RequiredArgsConstructor;
import org.choongang.commons.ExceptionProcessor;
import org.choongang.commons.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller("OrderDetailsController")
@RequiredArgsConstructor
@RequestMapping("/orderDetail")
public class OrderDetailsController implements ExceptionProcessor {

  private final Utils utils;

  @GetMapping("/main")
  public String orderDetail() {

    return utils.tpl("orderDetail/main");
  }

  @GetMapping("/receipt")
  public String receipt() {

    return utils.tpl("orderDetail/receipt");
  }

  @GetMapping("/review")
  public String showReviewPage(Model model) {

    return utils.tpl("orderDetail/review");
  }

  @PostMapping("/submitReview")
  @ResponseBody
  public String submitReview(@RequestParam String reviewPage) {

    return "success";
  }
}
