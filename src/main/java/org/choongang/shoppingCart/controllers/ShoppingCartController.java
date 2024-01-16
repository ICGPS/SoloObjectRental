package org.choongang.shoppingCart.controllers;

import lombok.RequiredArgsConstructor;
import org.choongang.commons.ExceptionProcessor;
import org.choongang.commons.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("shoppingCartController")
@RequestMapping("/shoppingCart")
@RequiredArgsConstructor
public class ShoppingCartController implements ExceptionProcessor {

//  private final ShoppingDataRepository shoppingDataRepository;
private final Utils utils;

  @GetMapping("/cart")
  public String ShoppingCart() {

    return utils.tpl("shoppingCart/cart");
  }
//  @GetMapping("/review")
//  public String re() {
//
//    return  utils.tpl("orderDetail/review");
//  }
//
//  @GetMapping("/receipt")
//  public String res() {
//
//    return  utils.tpl("orderDetail/receipt");
//  }

  @GetMapping("/order")
  public String ShoppingCartOrder() {

    return  utils.tpl("shoppingCart/order");
  }

  @GetMapping("/continueShopping")
  public String continueShopping() {

    return utils.tpl("product/list");
  }

}
