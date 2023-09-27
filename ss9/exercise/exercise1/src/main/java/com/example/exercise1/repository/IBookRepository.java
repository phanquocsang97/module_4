package com.example.exercise1.repository;

import com.example.exercise1.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBookRepository extends JpaRepository<Book,Integer> {
    @Query(value = "select * from Book where name like:nameSearch",nativeQuery = true)
    Page<Book> findAllBookByName(Pageable pageable, @Param("nameSearch") String nameSearch);
}
