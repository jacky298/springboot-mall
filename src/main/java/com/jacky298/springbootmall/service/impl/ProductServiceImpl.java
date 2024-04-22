package com.jacky298.springbootmall.service.impl;

import com.jacky298.springbootmall.dao.ProductDao;
import com.jacky298.springbootmall.dto.ProductQueryParam;
import com.jacky298.springbootmall.dto.ProductRequest;
import com.jacky298.springbootmall.model.Product;
import com.jacky298.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getProducts(ProductQueryParam productQueryParam) {
        List<Product> productList = productDao.getProducts(productQueryParam);

        return productList;
    }

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    public void updateProduct(Integer productId, ProductRequest productRequest){
        productDao.updateProduct(productId, productRequest);
    }

    public void deleteProductById(Integer productId){
        productDao.deleteProductById(productId);
    }
}
