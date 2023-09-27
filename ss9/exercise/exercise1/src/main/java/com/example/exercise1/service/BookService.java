package com.example.exercise1.service;

import com.example.exercise1.model.Book;
import com.example.exercise1.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService{
    @Autowired
    private IBookRepository bookRepository;
    @Override
    public Page<Book> findAll(Pageable pageable, String nameSearch) {
        return bookRepository.findAllBookByName(pageable,"%" + nameSearch + "%");
    }

    @Override
    public boolean addBook(Book book) {
        try {
            Book bookEntity = bookRepository.save(book);
            return bookEntity != null;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteBook(Book book) {
        try {
            Book bookEntity = bookRepository.findById(book.getId()).get();
            bookRepository.delete(book);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean updateBook(Book book) {
        try {
            Book bookEnity = bookRepository.save(book);
            return bookEnity != null;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).get();
    }
}
