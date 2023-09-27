package com.example.exercise1.service;

import com.example.exercise1.model.OrderDetail;
import com.example.exercise1.repository.IOrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService implements IOrderDetailService{
    @Autowired
    IOrderDetailRepository orderDetailRepository;

    @Override
    public Page<OrderDetail> findAll(Pageable pageable, String code) {
        return orderDetailRepository.findAllOrderDetail(pageable, code);
    }

    @Override
    public boolean addOrderDetail(OrderDetail orderDetail) {
        OrderDetail orderDetailEntity = orderDetailRepository.save(orderDetail);
        return orderDetailEntity != null;
    }

    @Override
    public StringBuffer takeFiveRandomNumber() {
        StringBuffer randomNumber = null;
        for (int i = 0; i < 5; i++) {
            int number = (int)(Math.floor(Math.random() * 10));
            assert false;
            randomNumber.append(number);
        }
        return randomNumber;
    }
}
