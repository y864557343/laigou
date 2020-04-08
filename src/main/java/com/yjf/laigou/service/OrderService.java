package com.yjf.laigou.service;



import com.yjf.laigou.pojo.Order;
import com.yjf.laigou.pojo.OrderItem;

import java.util.List;

public interface OrderService {

    String waitPay = "waitPay";
    String waitDelivery = "waitDelivery";
    String waitConfirm = "waitConfirm";
    String waitReview = "waitReview";
    String finish = "finish";
    String delete = "delete";

    void add(Order c);
    float add(Order c, List<OrderItem> ois);
    void delete(int id);
    void update(Order c);
    Order get(int id);
    List findList();
    List findList(int uid, String excludedStatus);
}
