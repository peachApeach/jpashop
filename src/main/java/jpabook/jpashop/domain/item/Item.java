package jpabook.jpashop.domain.item;

import jakarta.persistence.*;
import jpabook.jpashop.domain.Category;
import jpabook.jpashop.exception.NotEnoghStockException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
// 상속 관계 전략을 부모 클래스에 지정
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public abstract class Item {     // 구현체를 가치고 할 것이기 때문에 추상클래스
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    //// 비즈니스 로직
    // 재고 증가
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    //재고 감소
    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if (restStock<0) {
            throw  new NotEnoghStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }
}
