package com.example.jpa_11_webapplication.repository;

import com.example.jpa_11_webapplication.domain.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@Import(ItemRepository.class)
class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;


    @Test
    @DisplayName("최초 상품등록 성공")
    void test1() {
        Book book = new Book("june", "123456");
        itemRepository.save(book);

        assertThat(book).isEqualTo(itemRepository.findOne(book.getId()));
    }
}