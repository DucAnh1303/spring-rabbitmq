package com.rabbitmq.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private ProductService productService;


    @PostMapping("/message")
    public String send(@RequestBody Product product) {
        return productService.sendMessage(product);
    }

    @GetMapping("/receiver")
    public Product receiver() {
        productService.receiver();
        return null;
    }

}
