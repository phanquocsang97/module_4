package com.example.library.service;

import com.example.library.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> findAll(Pageable pageable, String searchName);

    Book findById(int id);

    void update(Book book, int bookId);
    Book rentBook(int id);

    Book payBook(int id);

}
