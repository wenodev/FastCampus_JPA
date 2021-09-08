package com.example.FastJpa.service;

import com.example.FastJpa.repository.BookRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class BookServiceTest {
    private BookRepository bookRepository = mock(BookRepository.class);
    private BookService bookService = new BookService(bookRepository);
}
