package org.choongang.order.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.choongang.cart.constants.CartType;
import org.choongang.cart.service.CartData;
import org.choongang.cart.service.CartDeleteService;
import org.choongang.cart.service.CartInfoService;
import org.choongang.commons.ExceptionProcessor;
import org.choongang.commons.Utils;
import org.choongang.order.constants.OrderStatus;
import org.choongang.order.entities.OrderInfo;
import org.choongang.order.service.OrderInfoService;
import org.choongang.order.service.OrderSaveService;
import org.choongang.order.service.OrderStatusService;
import org.choongang.order.entities.OrderInfo;
import org.choongang.order.service.OrderInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
@SessionAttributes({"cartData", "mode"}) // model.addAttribute -> 세션쪽에도 자동 추가
public class OrderController implements ExceptionProcessor {

  private final CartInfoService cartInfoService;
  private final OrderInfoService orderInfoService;

  private final CartDeleteService cartDeleteService;
  private final OrderSaveService orderSaveService;
  private final OrderStatusService orderStatusService;
  private final OrderInfoService orderInfoService;

  private final Utils utils;

  /**
   * 주문서 작성
   *
   * @param seq : 장바구니 등록 번호
   *              장바구니 등록번호가 없으면 바로구매 : CartType.DIRECT
   *                  바로구매(DIRECT) : 상품 상세에서 바로 주문하는 경우
   *                  CART : 장바구니 -> 주문하기
   * @param model
   * @return
   */
  @GetMapping
  public String order(@RequestParam(name="seq", required = false) List<Long> seq, @ModelAttribute RequestOrder form, Model model) {
    commonProcess("order", model);

    CartType mode = seq == null || seq.isEmpty() ? CartType.DIRECT : CartType.CART;
    CartData data = cartInfoService.getCartInfo(mode, seq);


    model.addAttribute("cartData", data);

    return utils.tpl("order/order_form");
  }

  @PostMapping
  public String orderPs(@Valid RequestOrder form, Errors errors, Model model, SessionStatus status) {
    commonProcess("order", model);

    if (errors.hasErrors()) {
      return utils.tpl("order/order_form");
    }

    OrderInfo orderInfo = orderSaveService.save(form);

    // 결제 수단이 카드, 가상계좌, 계좌이체 -> PG

    // 장바구니 주문 상품 삭제
    cartDeleteService.delete(form.getCartSeq());

    // 주문 상태 -> READY -> ORDER : 주문접수 -> 메일 전송
    orderStatusService.change(orderInfo.getSeq(), OrderStatus.ORDER);

    status.setComplete(); // cartData 세션 비우기

    model.addAttribute("orderInfo", orderInfo);

    return "redirect:/order/end/" + orderInfo.getSeq();
//    return utils.tpl("order/end");
  }

  @GetMapping("/end/{seq}")
  public String orderEnd(@PathVariable("seq") Long seq, Model model) {
    OrderInfo orderInfo = orderInfoService.get(seq);

    model.addAttribute("orderInfo", orderInfo);

    return utils.tpl("order/end");
  }

  /* 구매 영수증 연결 추가 S */
  @GetMapping("/purchaseReceipt")
  // (GET에서 사용) orderDone에 매개변수를 넣은 것 = "/purchaseReceipt?매개변수" 엔트포인트에 쿼리스트링으로 넣는 것과 동일
  public String orderDone(@RequestParam Long orderSeq, Model model) {
    OrderInfo orderInfo = orderInfoService.get(orderSeq);
    model.addAttribute("orderInfo", orderInfo);
    return utils.tpl("mypage/purchaseReceipt");
  }
  /* 구매 영수증 연결 추가 E */

  /**
   * 주문 공통 처리
   *
   * @param mode
   * @param model
   */
  private void commonProcess(String mode, Model model) {
    mode = StringUtils.hasText(mode) ? mode : "order";
    String pageTitle = Utils.getMessage("주문하기", "commons");

    List<String> addCommonScript = new ArrayList<>();

    if (mode.equals("order")) {
      addCommonScript.add("address");
    } else if (mode.equals("end")) {
      pageTitle = Utils.getMessage("주문완료", "commons");
    }

    model.addAttribute("addCommonScript", addCommonScript);
    model.addAttribute("pageTitle", pageTitle);
    model.addAttribute("mode", mode);
  }
}