package com.example.FastJpa.repository;

import com.example.FastJpa.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@Transactional
@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void test_column(){
        Book book = bookRepository.save(Book.builder()
                .name("dummy-book-name-1")
                .build());
        System.out.println(book);
    }

}
