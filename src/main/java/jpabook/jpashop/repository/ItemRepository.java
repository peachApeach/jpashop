package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    // 상품 저장
    public void save(Item item) {
        if (item.getId() == null) {     // 저장하기 전까지 id가 없음
            em.persist(item);
        }
        else {
            em.merge(item);     // 업데이트 개념
        }
    }

    // item 하나 조회
    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    // 모두 찾기
    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class).getResultList();
    }
}
