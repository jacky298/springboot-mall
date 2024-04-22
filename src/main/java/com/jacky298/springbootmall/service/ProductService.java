package com.jacky298.springbootmall.service;

import com.jacky298.springbootmall.dto.ProductQueryParam;
import com.jacky298.springbootmall.dto.ProductRequest;
import com.jacky298.springbootmall.model.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Integer productId);
    List<Product> getProducts(ProductQueryParam productQueryParam);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId, ProductRequest productRequest);
    void deleteProductById(Integer productId);

}
