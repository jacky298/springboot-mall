package com.jacky298.springbootmall.dao;

import com.jacky298.springbootmall.dataObject.ProductRequest;
import com.jacky298.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts(String category, String search);
    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId, ProductRequest productRequest);
    void deleteProductById(Integer productId);
}
