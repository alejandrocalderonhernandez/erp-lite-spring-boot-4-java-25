package com.debuggeandoideas.erp_lite.domain.ports.repositories;

import com.debuggeandoideas.erp_lite.domain.entities.order.OrderRoot;
import com.debuggeandoideas.erp_lite.domain.entities.order.OrderNumber;
import com.debuggeandoideas.erp_lite.domain.entities.product.ProductId;
import com.debuggeandoideas.erp_lite.domain.shared.CustomerId;

import java.util.List;
import java.util.Optional;


/**
 *  Port for storage o consult Orders
 */
public interface OrderRepositoryPort {
    OrderRoot save(OrderRoot order);
    Optional<OrderRoot> findAbyId(ProductId id);
    Optional<OrderRoot> findAbyOrderNumber(OrderNumber orderNumber);
    List<OrderRoot> findByCustomerId(CustomerId customerId);
    void delete(OrderRoot order);

}
