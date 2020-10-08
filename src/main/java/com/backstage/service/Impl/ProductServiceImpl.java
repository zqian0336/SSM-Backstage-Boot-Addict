package com.backstage.service.Impl;

import com.backstage.dao.ProductDao;
import com.backstage.pojo.Product;
import com.backstage.service.ProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> findAllProduct(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        return productDao.findAllProduct();
    }

    @Override
    public void saveProduct(Product product) {
        productDao.saveProduct(product);

    }

    @Override
    public void deleteProduct(String id) {
        productDao.deleteProduct(id);

    }

    @Override
    public void updateProduct(Product product) {
        productDao.updateProduct(product);

    }

    @Override
    public Product findProductById(String id) {
        return productDao.findProductById(id);
    }

    @Override
    public List<Product> findAllProductByMsg(int page, int pageSize, String searchMsg) {
        PageHelper.startPage(page, pageSize);
        return productDao.findAllProductByMsg(searchMsg);
    }
}
