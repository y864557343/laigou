package com.yjf.laigou.service;


import com.yjf.laigou.pojo.ProductImage;

import java.util.List;

public interface ProductImageService {

    String type_single = "type_single";
    String type_detail = "type_detail";

    void add(ProductImage pi);

    void delete(int id);

    void update(ProductImage pi);

    ProductImage get(int id);

    List findList(int pid, String type);
}
