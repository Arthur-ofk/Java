package com.jj.paymentservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jj.paymentservice.Product;

@FeignClient(name  = "product-service", url = "${productservice.url}")
public interface ProductClient {

    @RequestMapping(method = RequestMethod.GET,value = "/products/all")
   
    List<Product> getAllProducts();
}
