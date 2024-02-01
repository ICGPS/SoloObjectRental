package org.choongang.orderDetails.controllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.choongang.commons.ExceptionProcessor;
import org.choongang.commons.Utils;
import org.choongang.member.entities.Member;
import org.choongang.orderDetails.entities.QnA;
import org.choongang.orderDetails.entities.Review;
import org.choongang.orderDetails.service.QnAService;
import org.choongang.orderDetails.service.ReviewService;
import org.choongang.product.entities.Product;
import org.choongang.product.repositories.ProductRepository;
import org.choongang.product.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("OrderDetailsController")
@RequiredArgsConstructor
@RequestMapping("/orderDetail")
public class OrderDetailsController implements ExceptionProcessor {

  private final Utils utils;
  private final ReviewService reviewService;
  private final ProductInfoService productInfoService;
  private final QnAService qnAService;
  private final ProductRepository productRepository;

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
  public String submitReview(@ModelAttribute Review review, Model model) {

    reviewService.save(review);

    model.addAttribute("script", "self.close();");

    return "common/_execute_script";
  }

  @GetMapping("/qnaDetail")
  public String QnADetail(@RequestParam(name="seq", required = false) Long seq, Model model) {
    Product product = productInfoService.get(seq);

    model.addAttribute("product", product);

    return utils.tpl("orderDetail/qnaDetail");
  }


  @PostMapping("/submitQnA")
  public String submitQnA(@ModelAttribute RequestQna qna,Model model) {

    qnAService.save(qna);

    model.addAttribute("script", "self.close();");

    return "common/_execute_script";
  }
}

