package com.inspire12.likelionbackend.module.store.domain.adapter;


import com.inspire12.likelionbackend.module.order.application.port.out.StoreStatusPort;
import org.springframework.stereotype.Component;

@Component
public class StoreApiAdapter implements StoreStatusPort{ //  TODO: Order에서 만든 StoreStatusPort포트를 implements 해서 기능 구현

    @Override
    public Boolean getStoreOpenStatus(Long storeId) {
        return true;
    }
}
