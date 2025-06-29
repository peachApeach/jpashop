package jpabook.jpashop.repository;

import jpabook.jpashop.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderSearch {

    // where 문 조회 조건
    private String memberName;
    private OrderStatus orderStatus;

}
