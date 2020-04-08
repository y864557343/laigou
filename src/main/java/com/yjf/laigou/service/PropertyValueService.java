package com.yjf.laigou.service;

import com.yjf.laigou.pojo.Product;
import com.yjf.laigou.pojo.PropertyValue;

import java.util.List;

public interface PropertyValueService {
    void init(Product p);
    void update(PropertyValue pv);

    PropertyValue get(int ptid, int pid);
    List<PropertyValue> list(int pid);
}


