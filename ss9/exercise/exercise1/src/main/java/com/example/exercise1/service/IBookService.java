package com.example.exercise1.service;

import com.example.exercise1.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {
    Page<Book> findAll(Pageable pageable,String nameSearch);
    boolean addBook(Book book);
    boolean deleteBook(Book book);
    boolean updateBook(Book book);
    Book findById(int id);
}
