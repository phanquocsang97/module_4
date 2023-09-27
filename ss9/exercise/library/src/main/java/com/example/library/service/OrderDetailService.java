package com.example.library.service;

import com.example.library.model.OrderDetail;
import com.example.library.repository.IOrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService implements IOrderDetailService{
    @Autowired
    private IOrderDetailRepository orderDetailRepository;
    @Override
    public boolean saveOrderDetail(int bookId, int code, int customerId) {
         orderDetailRepository.save(bookId,code,customerId);
         return true;
    }

    @Override
    public Page<OrderDetail> findAll(Pageable pageable) {
        return orderDetailRepository.findAll(pageable);
    }

    @Override
    public OrderDetail findById(int id) {
        return orderDetailRepository.findById(id).get();
    }

    @Override
    public void deleteOrder(int id) {
        orderDetailRepository.deleteById(id);
    }

    @Override
    public OrderDetail findByCode(int code) {
        return orderDetailRepository.findByCode(code);
    }
}
