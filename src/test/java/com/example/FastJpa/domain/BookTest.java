package com.example.FastJpa.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    /*
    - 순환참조를 발생시켜본다.
    - toString이 덜 필요한 쪽에 exclude를 사용한다.
     */
    @Test
    void test_toString_exclude(){
        Book book = Book.builder()
                .category("cate")
                .build();

        BookReviewInfo bookReviewInfo = BookReviewInfo.builder()
                .book(book)
                .build();

        book.setBookReviewInfo(bookReviewInfo);

        System.out.println("book: " + book);
        System.out.println("bookReviewInfo: " + bookReviewInfo);
    }

}

