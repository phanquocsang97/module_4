package com.example.library.repository;

import com.example.library.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IBookRepository extends JpaRepository<Book,Integer> {
    @Query(value = "select * from sach where so_luong > 0", nativeQuery = true)
    Page<Book> findAll(Pageable pageable);
}
