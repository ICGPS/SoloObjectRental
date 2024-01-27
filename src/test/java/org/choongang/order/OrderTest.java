package org.choongang.order;

import org.choongang.order.constants.OrderStatus;
import org.choongang.order.entities.OrderInfo;
import org.choongang.order.service.OrderInfoService;
import org.choongang.order.service.OrderSaveService;
import org.choongang.order.service.OrderStatusService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@Transactional
@TestPropertySource(properties = "spring.profiles.active=dev")
public class OrderTest {
    @Autowired
    private OrderSaveService orderSaveService;

    @Autowired
    private OrderStatusService orderStatusService;

    @Autowired
    private OrderInfoService orderInfoService;
    @Test
    void test() {
        Long seq = 1706260350516L; // DB ORDER_INFO 에서 가져온 seq값

        orderStatusService.change(seq, OrderStatus.ORDER, false); // 상태를 ORDER 로 변경

        OrderInfo data  = orderInfoService.get(seq);
        OrderStatus status = data.getStatus();
        System.out.println("=================테스트===================");
        System.out.println(status);

        data.getOrderItems().forEach(i -> System.out.println(i.getStatus()));
    }
    @Test
    void test2() {
        Long seq = 1706253520886L;
        List<Long> orderItemSeq = Arrays.asList(2L);

        OrderInfo data = orderInfoService.get(seq);
        OrderStatus status = data.getStatus();
        System.out.println("=================테스트===================");
        System.out.println(status);

        data.getOrderItems().forEach(i -> System.out.println(i.getStatus()));
    }
}
