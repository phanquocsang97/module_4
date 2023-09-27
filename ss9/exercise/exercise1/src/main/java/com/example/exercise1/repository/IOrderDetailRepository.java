package com.example.exercise1.repository;

import com.example.exercise1.model.Book;
import com.example.exercise1.model.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail,Integer> {
    @Query(value = "select * from Order_detail where code_number like:code",nativeQuery = true)
    Page<OrderDetail> findAllOrderDetail(Pageable pageable, @Param("code") String code);
}
