package com.example.restfulapi.controller;

import com.example.restfulapi.entity.Product;
import com.example.restfulapi.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // @controller + @ResponseBody
@RequestMapping("/rest/product/")
@CrossOrigin(origins = "*") // sử dụng để ánh xạ các đường dẫn
public class ProductRestController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("hien-thi") // @ResponseBody trả kết quả json từ server về client
    public ResponseEntity getAll() {
        return productService.getAll();
    }
    // ResponseEntity sử dụng để xử lý và tạo các phản hồi HTTP trong ứng dụng web

    @GetMapping("detail/{id}")
    public ResponseEntity<Product> detail(@PathVariable("id") Integer id){
        return productService.detail(id);
    }

    @PostMapping("create")
    public ResponseEntity<Product> create(@RequestBody Product product){ //@RequestBody nhận dữ liệu json được truyền từ client vào server
        return productService.create(product);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") Integer id,@RequestBody Product product){
        return productService.update(id,product);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Integer id){
        return productService.deleteProduct(id);
    }
}