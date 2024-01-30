package org.choongang.order.service;

import lombok.RequiredArgsConstructor;
import org.choongang.order.entities.OrderInfo;
import org.choongang.order.repositories.OrderInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderInfoService {
  private final OrderInfoRepository orderInfoRepository;

  /**
   * 주문서 조회
   *
   * @param seq
   * @return
   */
  public OrderInfo get(Long seq) {
    OrderInfo orderInfo = orderInfoRepository.findById(seq).orElseThrow(OrderNotFoundException::new);

    return orderInfo;
  }

  public List<OrderInfo> orderList() {
    return orderInfoRepository.findAll();
  }
}