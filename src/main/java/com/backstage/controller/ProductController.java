package com.backstage.controller;

import com.backstage.pojo.Product;
import com.backstage.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {
    private String uuid;

    protected ProductService productService;

    @Autowired
    public void setProductService(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("findAllProduct")
    @PreAuthorize("permitAll()")
    public ModelAndView findAllProduct(int page, int pageSize){
        ModelAndView mv = new ModelAndView();
        List<Product> products = productService.findAllProduct(page, pageSize);
        PageInfo pageInfo = new PageInfo(products);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("product-list");
        return mv;

    }

    @PostMapping("saveProduct")
    @PreAuthorize("authentication.principal.username=='Spencer' || authentication.principal.username=='admin'")
    public String saveProduct(Product product){
        productService.saveProduct(product);
        String view = "redirect:findAllProduct";
        return view;
    }

    @GetMapping("deleteProduct")
    @PreAuthorize("authentication.principal.username=='Spencer' || authentication.principal.username=='admin'")
    public void deleteProduct(String id){
        productService.deleteProduct(id);
    }

    @GetMapping("findProductById")
    @PreAuthorize("permitAll()")
    public ModelAndView findProductById(String id){
        ModelAndView mv = new ModelAndView();
        Product product = productService.findProductById(id);
        mv.addObject("product", product);
        mv.setViewName("product-details");
        return mv;
    }

    @GetMapping("findProductById2")
    @PreAuthorize("permitAll()")
    public ModelAndView findProductById2(String id){
        ModelAndView mv = new ModelAndView();
        uuid = id;
        Product product = productService.findProductById(id);
        mv.addObject("product", product);
        mv.setViewName("product-edit");
        return mv;
    }

    @GetMapping("updateProduct")
    @PreAuthorize("authentication.principal.username=='Spencer' || authentication.principal.username=='admin'")
    public String updateProduct(Product product){
        if(uuid != null && !"".equals(uuid)){
            product.setId(uuid);
        }
        productService.updateProduct(product);
        uuid = null;
        String view = "redirect:findAllProduct";
        return view;
    }

    @GetMapping("findAllProductByMsg")
    public ModelAndView findAllProductByMsg(int page, int pageSize, String searchMsg){
        ModelAndView mv = new ModelAndView();
        mv.addObject("searchMsg", searchMsg);
        List<Product> products = productService.findAllProductByMsg(page, pageSize, searchMsg);
        PageInfo pageInfo = new PageInfo(products);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("product-list-search");
        return mv;
    }

}
