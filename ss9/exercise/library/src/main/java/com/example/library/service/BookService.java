package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService{
    @Autowired
    private IBookRepository bookRepository;
    @Override
    public Page<Book> findAll(Pageable pageable, String searchName) {
        return bookRepository.findAll(pageable,"%"+searchName+"%");
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void update(Book book, int bookId) {
        bookRepository.updateBook(book,bookId);
    }

    @Override
    public Book rentBook(int id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null && book.getQuantity() > 0) {
            book.setQuantity(book.getQuantity() - 1);
            bookRepository.save(book);
            return book;
        }
        return null;
    }

    @Override
    public Book payBook(int id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            book.setQuantity(book.getQuantity() + 1);
            bookRepository.save(book);
            return book;
        }
        return null;
    }
}
