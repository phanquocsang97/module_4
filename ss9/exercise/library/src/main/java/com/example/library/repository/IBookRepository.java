package com.example.library.repository;

import com.example.library.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "select * from book where book_name like :name", nativeQuery = true)
    Page<Book> findAll(Pageable pageable, @Param("name") String searchName);

    @Transactional
    @Modifying
    @Query(value = "update book set quantity = :#{#book.quantity} where book_id like :id", nativeQuery = true)
    void updateBook(Book book, @Param("id") int bookId);
}
