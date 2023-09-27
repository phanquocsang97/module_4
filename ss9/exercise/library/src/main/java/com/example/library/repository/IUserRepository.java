package com.example.library.repository;

import com.example.library.model.BorrowBooks;
import com.example.library.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IUserRepository extends JpaRepository<User,Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO borrow_book (id_borrow_book, id, id_book,status) VALUES (FLOOR(10000 + RAND() * 90000),:id,:iduser,0)", nativeQuery = true)
    void save(@Param("id") int id, @Param("iduser") int iduser);
    @Modifying
    @Transactional
    @Query(value = "UPDATE book SET quantity = quantity -1  WHERE (id_book =:id)",nativeQuery = true)
    void createBook(@Param("id")int id);

    @Query(value = "SELECT * FROM muon_sach WHERE muon_sach.id = :id AND muon_sach.status = 0",nativeQuery = true)
    Page<BorrowBooks> deleteBook(Pageable pageable, @Param("id") int id);
    @Query(value = "SELECT * FROM muon_sach WHERE muon_sach.id = :id AND muon_sach.id_muon_sach=:idBook AND muon_sach.status = 0",nativeQuery = true)
    List<BorrowBooks> listDeleteBook(int id, int idBook);
    @Modifying
    @Transactional
    @Query(value = "UPDATE muon_sach SET status = 1 WHERE id_borrow_book = :idBook AND id = :id",nativeQuery = true)
    void deleteBorrowBook(int id, int idBook);
}
