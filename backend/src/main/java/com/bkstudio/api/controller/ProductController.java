package com.bkstudio.api.controller;

import com.bkstudio.api.entity.Product;
import com.bkstudio.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products") // Đường dẫn chung cho toàn bộ API sản phẩm
public class ProductController {

    @Autowired
    private ProductRepository productRepository; // Gọi anh thủ kho ra làm việc

    // API 1: Thêm mới (Create) một Figure vào kho
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        // Thủ kho nhận product và lưu thẳng xuống database
        return productRepository.save(product); 
    }

    // API2: Lấy danh sách tất cả Figure (Read)
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // API 3: Cập nhật thông tin (Update)
    // Đường dẫn sẽ có dạng: /api/products/1 (số 1 là id của sản phẩm cần sửa)
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        // 1. Tìm xem có sản phẩm nào mang id này không
        Product product = productRepository.findById(id).orElseThrow();
        
        // 2. Cập nhật thông tin mới (Ví dụ: khách đổi giá, đổi tên)
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setStockQuantity(productDetails.getStockQuantity());
        
        // 3. Lưu lại vào két sắt
        return productRepository.save(product);
    }

    // API 4: Xóa sản phẩm (Delete)
    // Đường dẫn sẽ có dạng: /api/products/1 
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return "Đã xóa thành công Figure có mã số: " + id;
    }
}