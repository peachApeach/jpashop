package jpabook.jpashop.service;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;

public class ItemUpdateTest {

    @Autowired
    EntityManager em;

    @Transactional
    void updateTest() throws Exception {
        Book book = em.find(Book.class, 1L);

        //TX
        book.setName("aaaaa");

        // 변경 감지 = 더티체크
        // TX Commit


    }
}
