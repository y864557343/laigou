package com.yjf.laigou.service.impl;


import com.yjf.laigou.mapper.OrderMapper;
import com.yjf.laigou.pojo.Order;
import com.yjf.laigou.pojo.OrderExample;
import com.yjf.laigou.pojo.OrderItem;
import com.yjf.laigou.pojo.User;
import com.yjf.laigou.service.OrderItemService;
import com.yjf.laigou.service.OrderService;
import com.yjf.laigou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    UserService userService;
    @Autowired
    OrderItemService orderItemService;

    @Override
    public void add(Order c) {
        orderMapper.insert(c);
    }

    @Override
    public void delete(int id) {
        orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Order c) {
        orderMapper.updateByPrimaryKeySelective(c);
    }

    @Override
    public Order get(int id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,rollbackForClassName="Exception")
    public float add(Order o, List<OrderItem> ois) {
        float total = 0;
        add(o);

        if(false)
            throw new RuntimeException();

        for (OrderItem oi: ois) {
            oi.setOid(o.getId());
            orderItemService.update(oi);
            total+=oi.getProduct().getPromotePrice()*oi.getNumber();
        }
        return total;
    }

    public List<Order> findList(){
        OrderExample example =new OrderExample();
        example.setOrderByClause("id desc");
        List<Order> orders = orderMapper.selectByExample(example);
        setUser(orders);
        return orders;
    }

    @Override
    public List findList(int uid, String excludedStatus) {
        OrderExample example =new OrderExample();
        example.createCriteria().andUidEqualTo(uid).andStatusNotEqualTo(excludedStatus);
        example.setOrderByClause("id desc");
        return orderMapper.selectByExample(example);
    }

    ;

    public void setUser(List<Order> os){
        for (Order o : os)
            setUser(o);
    }
    public void setUser(Order o){
        int uid = o.getUid();
        User u = userService.get(uid);
        o.setUser(u);
    }

}

