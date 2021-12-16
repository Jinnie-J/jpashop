package jpaproject.jpashop.service;

import jpaproject.jpashop.domain.item.Item;
import jpaproject.jpashop.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ItemServiceTest {

    @Autowired ItemService itemService;
    @Autowired ItemRepository itemRepository;

    @Test
    public void 상품저장() throws Exception{
        //given
        Item item = new Item();
        item.setName("itemA");

        //when
       itemService.saveItem(item);

        //then
        assertEquals(item, itemRepository.findOne(item.getId()));
    }
}
