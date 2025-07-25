package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional      // 저장안됨
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    // 변경 감지 기능
    @Transactional
    public void updateItem(Long itemId, String name, int price, int stock) {
        Item findItem = itemRepository.findOne(itemId);
        findItem.setPrice(price);
        findItem.setName(name);
        findItem.setStockQuantity(stock);
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
