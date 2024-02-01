package org.choongang.admin.order;

import lombok.RequiredArgsConstructor;
import org.choongang.admin.menus.Menu;
import org.choongang.admin.menus.MenuDetail;
import org.choongang.commons.ExceptionProcessor;
import org.choongang.order.entities.OrderInfo;
import org.choongang.order.service.OrderInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller("adminOrderController")
@RequestMapping("/admin/order")
@RequiredArgsConstructor
public class OrderController implements ExceptionProcessor {
    private final OrderInfoService orderInfoService;
    @ModelAttribute("menuCode")
    public String getMenuCode() {
        return "order";
    }

    @ModelAttribute("subMenus")
    public List<MenuDetail> getSubMenus() {
        return Menu.getMenus("order");
    }

    @ModelAttribute("orderList")
    public List<OrderInfo> getList() {
        return orderInfoService.getList();
    }

    @GetMapping
    public String list(Model model) {
        List<OrderInfo> data = orderInfoService.getList();


        return "admin/order/list";
    }
}