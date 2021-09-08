package com.example.FastJpa.service;

import com.example.FastJpa.domain.Author;
import com.example.FastJpa.domain.Book;
import com.example.FastJpa.domain.Publisher;
import com.example.FastJpa.repository.BookRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class BookServiceTest {
    private BookRepository bookRepository = mock(BookRepository.class);
    private BookService bookService = new BookService(bookRepository);

    /*
    - 등록할때 부터 name, category, publisher, author가 필요하다.
     */
    @Test
    void test_create(){
        Publisher.builder()
                .name("test-publisher")
                .build();

        Author.builder()
                .name("test-auth")
                .build();

        Book.builder()
                .name("test-book-name")
                .category("test-book-category")
                .build();
    }

}
