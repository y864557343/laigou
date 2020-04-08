package com.yjf.laigou.service;



import com.yjf.laigou.pojo.Order;
import com.yjf.laigou.pojo.OrderItem;

import java.util.List;

public interface OrderItemService {


    void add(OrderItem c);

    void delete(int id);
    void update(OrderItem c);
    OrderItem get(int id);
    List list();

    void stuff(List<Order> os);

    void stuff(Order o);

    int getSaleCount(int pid);

    List<OrderItem> findListByUser(int uid);
}

