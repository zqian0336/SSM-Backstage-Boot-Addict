package com.backstage.dao;

import com.backstage.pojo.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAllProduct();

    void saveProduct(Product product);

    void deleteProduct(String id);

    void updateProduct(Product product);

    Product findProductById(String id);

    List<Product> findAllProductByMsg(String searchMsg);


}
