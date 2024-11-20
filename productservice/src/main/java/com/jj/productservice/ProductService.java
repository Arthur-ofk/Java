package com.jj.productservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Створення нового продукту
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // Отримання всіх продуктів
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Отримання продукту за ідентифікатором
    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    // Оновлення продукту
    public Product updateProduct(String id, Product productDetails) {
        return productRepository.findById(id).map(product -> {
            product.setName(productDetails.getName());
            product.setDescription(productDetails.getDescription());
            product.setPrice(productDetails.getPrice());
            product.setQuantity(productDetails.getQuantity());
            return productRepository.save(product);
        }).orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
    }

    // Видалення продукту
    public void deleteProduct(String id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found with id " + id);
        }
        productRepository.deleteById(id);
    }
}
