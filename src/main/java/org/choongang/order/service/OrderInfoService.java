package org.choongang.order.service;

import lombok.RequiredArgsConstructor;
import org.choongang.commons.Utils;
import org.choongang.commons.exceptions.AlertException;
import org.choongang.order.constants.OrderStatus;
import org.choongang.order.entities.OrderInfo;
import org.choongang.order.repositories.OrderInfoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderInfoService {
  private final OrderInfoRepository orderInfoRepository;
  private final Utils utils;
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

  public List<OrderInfo> getList() {
    return orderInfoRepository.findAll();
  }


  /**
   * 회원명에 해당하는 주문 정보 조회
   *
   * @param email 회원명
   * @return 주문 정보 리스트
   */
  public List<OrderInfo> getOrderInfoByEmail(String email) {
    return orderInfoRepository.findByorderEmail(email);
  }


  public void saveList(List<Long> chks) {
    if (chks == null || chks.isEmpty()) {
      throw new AlertException("수정할 주문을 선택하세요.", HttpStatus.BAD_REQUEST);
    }

    for (Long chk : chks) {
      String seq = utils.getParam("seq_" + chk);
      OrderInfo orderInfo = orderInfoRepository.findById(Long.valueOf(seq)).orElse(null);
      if (orderInfo == null) continue;

      String status = utils.getParam("status_" + seq);

      orderInfo.setStatus(OrderStatus.valueOf(status));

      orderInfoRepository.saveAndFlush(orderInfo);
    }
  }
}
