package org.choongang.orderDetails;

import lombok.RequiredArgsConstructor;
import org.choongang.commons.ExceptionProcessor;
import org.choongang.commons.Utils;
import org.choongang.orderDetails.entities.Review;
import org.choongang.orderDetails.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller("OrderDetailsController")
@RequiredArgsConstructor
@RequestMapping("/orderDetail")
public class OrderDetailsController implements ExceptionProcessor {

  private final Utils utils;
  private final ReviewService reviewService;

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

  @GetMapping("/reviewDetail")
  public String ReviewDetail(Model model) {

    return utils.tpl("orderDetail/review_detail");
  }

  @PostMapping("/submitReview")
  public String submitReview(@ModelAttribute Review form, Model model) {

    reviewService.save(form);

    return "redirect:/orderDetail/review";
  }
}
