package com.inspire12.likelionbackend.module.order.infrastructure.adpter;

import com.inspire12.likelionbackend.exception.OrderNotExistException;
import com.inspire12.likelionbackend.module.order.application.port.out.StoreStatusPort;
import com.inspire12.likelionbackend.module.order.domain.Order;
import com.inspire12.likelionbackend.module.order.domain.OrderRepository;
import com.inspire12.likelionbackend.module.order.infrastructure.repository.OrderJpaRepository;
import com.inspire12.likelionbackend.module.order.infrastructure.repository.entity.OrderEntity;
import com.inspire12.likelionbackend.module.order.support.mapper.OrderMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class OrderRepositoryAdapter implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;
    private final StoreStatusPort statusPort;

    public OrderRepositoryAdapter(OrderJpaRepository orderJpaRepository, StoreStatusPort statusPort) {
        this.orderJpaRepository = orderJpaRepository;
        this.statusPort = statusPort;
    }

    public Order getOrderByOrderId(Long orderId) {
        // TODO:1 가계 도메인한테(책임을 위임해서) 가계가 열렸는지 확인한다
        OrderEntity order = orderJpaRepository.findById(orderId)
                            .orElseThrow(OrderNotExistException::new);
        Boolean isOpenStore = statusPort.getStoreOpenStatus(order.getStoreId());
        // TODO:2 가계가 열렸으면 orderId로 주문을 가져와 도메인 객체로 변환해 반환한다
        if(isOpenStore){
            return OrderMapper.fromEntity(order);
        }

        throw new OrderNotExistException();
    }


    @Override
    public Order getOrderByCustomerId(Long customerId) {
        return OrderMapper.fromEntity(orderJpaRepository.findByCustomerId(customerId));
    }

    @Override
    public Order getOrderByOrderNumber(String orderNumber) {

        throw new OrderNotExistException();
    }
}
