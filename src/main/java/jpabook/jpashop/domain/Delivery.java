package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Delivery {
    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;
    
    @OneToOne(mappedBy = "delivery")       // FK는 많이 액세스하는 곳에 하는 것을 추천
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)        //Odinal은 numeric
    private DeliveryStatue status;      //READY, COMP
}
