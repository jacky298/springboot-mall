package com.jacky298.springbootmall.dao;

import com.jacky298.springbootmall.dto.ProductQueryParam;
import com.jacky298.springbootmall.dto.ProductRequest;
import com.jacky298.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts(ProductQueryParam productQueryParam);
    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId, ProductRequest productRequest);
    void deleteProductById(Integer productId);
}
