package com.example.exercise1.service;

import com.example.exercise1.model.Book;
import com.example.exercise1.model.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrderDetailService {
    Page<OrderDetail> findAll(Pageable pageable, String code);
    boolean addOrderDetail(OrderDetail orderDetail);
    StringBuffer takeFiveRandomNumber();
}
