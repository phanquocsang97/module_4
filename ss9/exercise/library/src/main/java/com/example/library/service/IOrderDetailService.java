package com.example.library.service;

import com.example.library.model.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrderDetailService {
    boolean saveOrderDetail(int bookId, int code, int customerId);

    Page<OrderDetail> findAll(Pageable pageable);

    OrderDetail findById(int id);

    void deleteOrder(int id);

    OrderDetail findByCode(int code);
}
