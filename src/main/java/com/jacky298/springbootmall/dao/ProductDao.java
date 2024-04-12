package com.jacky298.springbootmall.dao;

import com.jacky298.springbootmall.model.Product;

public interface ProductDao {
    Product getProductById(Integer productId);

}
