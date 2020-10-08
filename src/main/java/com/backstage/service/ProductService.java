package com.backstage.service;

import com.backstage.pojo.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAllProduct(int page, int pageSize);

    void saveProduct(Product product);

    void deleteProduct(String id);

    void updateProduct(Product product);

    Product findProductById(String id);

    List<Product> findAllProductByMsg(int page, int pageSize, String searchMsg);
}
