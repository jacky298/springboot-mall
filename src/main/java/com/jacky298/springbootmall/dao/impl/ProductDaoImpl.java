package com.jacky298.springbootmall.dao.impl;

import com.jacky298.springbootmall.dao.ProductDao;
import com.jacky298.springbootmall.dto.ProductQueryParam;
import com.jacky298.springbootmall.dto.ProductRequest;
import com.jacky298.springbootmall.model.Product;
import com.jacky298.springbootmall.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
//import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ProductDaoImpl implements ProductDao {


    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Product> getProducts(ProductQueryParam productQueryParam) {

        String sql = "SELECT product_id,product_name, category, image_url, price, stock, description, created_date, last_modified_date "+
            "FROM product WHERE 1 = 1";

        Map<String, Object> map = new HashMap<>();

        if(productQueryParam.getCategory() != null){
            sql = sql + " AND category = :category";
            map.put("category", productQueryParam.getCategory());
        }

        if(productQueryParam.getSearch() != null){
            sql = sql + " AND product_name LIKE :search";
            map.put("search", "%" + productQueryParam.getSearch() + "%");
        }

        //sorting (ORDER BY只能用拼接)
        sql = sql + " ORDER BY " + productQueryParam.getOrderBy() + " " + productQueryParam.getSort();

        //pagination
        sql = sql + " LIMIT :limit OFFSET :offset ";
        map.put("limit", productQueryParam.getLimit());
        map.put("offset",productQueryParam.getOffset());


        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        return productList;
    }

    @Override
    public Product getProductById(Integer productId) {
        String sql = " SELECT product_id,product_name, category, image_url, price, stock, description, created_date, last_modified_date" +
                " FROM product" +
                " WHERE product_id = :productId";


        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);


        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        if(productList != null){
            return productList.get(0);
        }else {
            return null;
        }

    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        String sql = "INSERT INTO product(product_name , category, image_url, price, stock, description, created_date, last_modified_date) "
                + "VALUES (:productName,:category,:imageUrl,:price,:stock,:description,:createdDate,:lastModifiedDate)";

        Map<String, Object> map = new HashMap<>();
        map.put("productName", productRequest.getProductName());
        map.put("category", productRequest.getCategory());
        map.put("imageUrl",productRequest.getImageUrl());
        map.put("price", productRequest.getPrice());
        map.put("stock",productRequest.getStock());
        map.put("description",productRequest.getDescription());

        Date now = new Date();
        map.put("createdDate",now);
        map.put("lastModifiedDate",now);
        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map), keyHolder);

        int productId = keyHolder.getKey().intValue();

        return productId;
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        String sql = "UPDATE product "+
                "SET product_name = :productName, category = :category, image_url = :imageUrl, price = :price, stock = :stock,description = :description, last_modified_date = :lastModifiedDate "+
                "WHERE product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        map.put("productName", productRequest.getProductName());
        map.put("category", productRequest.getCategory());
        map.put("imageUrl",productRequest.getImageUrl());
        map.put("price", productRequest.getPrice());
        map.put("stock",productRequest.getStock());
        map.put("description",productRequest.getDescription());

        Date now = new Date();
        map.put("lastModifiedDate",now);

        namedParameterJdbcTemplate.update(sql, map);

    }

    @Override
    public void deleteProductById(Integer productId) {
        String sql = "DELETE FROM product WHERE product_id = :productId ";
        Map<String, Object> map = new HashMap<>();

        map.put("productId", productId);

        namedParameterJdbcTemplate.update(sql, map);
    }
}
