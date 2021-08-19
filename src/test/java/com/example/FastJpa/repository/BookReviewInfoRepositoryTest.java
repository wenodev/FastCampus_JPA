package com.example.FastJpa.repository;

import com.example.FastJpa.domain.Book;
import com.example.FastJpa.domain.BookReviewInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class BookReviewInfoRepositoryTest {

    @Autowired
    private BookReviewInfoRepository bookReviewInfoRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    void test_save_and_select(){
        Book book = bookRepository.save(Book.builder()
                .name("dummy-book-name-1")
                .build());
        BookReviewInfo bookReviewInfo = bookReviewInfoRepository.save(BookReviewInfo.builder()
                        .book(book)
                        .reviewCount(300)
                        .averageReviewScore(1.0F)
                        .build());



        Book newBook = bookReviewInfoRepository.findById(1L).orElseThrow(RuntimeException::new).getBook();

        newBook.setName("name change");
    }
}
