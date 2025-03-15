package com.mystore.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mystore.app.entity.Product;

@Service
public class ProductService {

    private Integer currentId = 1;

    private List<Product> products = new ArrayList<>(
            Arrays.asList(
                    new Product(currentId++, "Smartphone", "Electronics", 40000.00, 50, "Latest model with advanced features"),
                    new Product(currentId++, "Laptop", "Electronics", 50000.00, 30, "High performance laptop"),
                    new Product(currentId++, "Wireless Headphones", "Electronics", 6000.00, 100, "Noise-cancelling headphones"),
                    new Product(currentId++, "T-shirt", "Clothing", 999.00, 200, "Comfortable cotton t-shirt"),
                    new Product(currentId++, "Jeans", "Clothing", 1499.00, 150, "Stylish denim jeans"),
                    new Product(currentId++, "Leather Jacket", "Clothing", 3000.00, 75, "Genuine leather jacket"),
                    new Product(currentId++, "Running Shoes", "Footwear", 499.00, 120, "Lightweight running shoes"),
                    new Product(currentId++, "Sneakers", "Footwear", 599.00, 200, "Trendy sneakers"),
                    new Product(currentId++, "Office Chair", "Furniture", 2900.00, 40, "Ergonomic office chair"),
                    new Product(currentId++, "Desk", "Furniture", 4000.00, 60, "Spacious office desk"),
                    new Product(currentId++, "Blender", "Appliances", 200.00, 80, "High-speed blender"),
                    new Product(currentId++, "Microwave Oven", "Appliances", 4999.00, 50, "Compact microwave oven"),
                    new Product(currentId++, "Coffee Maker", "Appliances", 1399.00, 90, "Automatic coffee maker"),
                    new Product(currentId++, "Smart Watch", "Electronics", 999.00, 150, "Feature-rich smart watch"),
                    new Product(currentId++, "Bluetooth Speaker", "Electronics", 2499.00, 250, "Portable Bluetooth speaker")
            )
    );

    public Product addProduct(Product product) {
        product.setId(currentId++);
        products.add(product);
        return product;
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProduct(Integer id) {
        return findProductById(id);
    }

    public Product updateProduct(Integer id, Product product) {
        Product p = findProductById(id);
        if (p == null) return null;
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        p.setCategory(product.getCategory());
        p.setStockQuantity(product.getStockQuantity());
        p.setDescription(product.getDescription());
        return p;
    }

    public String deleteProduct(Integer id) {
        Product p = findProductById(id);
        if (p == null) return "Product Not Found";
        products.remove(p);
        return "Product Deleted Successfully";
    }

    private Product findProductById(Integer id) {
        for (Product p: products) {
            if (p.getId().intValue() == id.intValue()) {
                return p;
            }
        }
        return null;
    }

    public List<Product> searchProductsByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }

    public List<Product> filterProductsByCategory(String category) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.getCategory().equalsIgnoreCase(category)) {
                result.add(p);
            }
        }
        return result;
    }

    public List<Product> filterProductsByPriceRange(double minPrice, double maxPrice) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.getPrice() >= minPrice && p.getPrice() <= maxPrice) {
                result.add(p);
            }
        }
        return result;
    }

    public List<Product> filterProductsByStockQuantityRange(int minQuantity, int maxQuantity) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.getStockQuantity() >= minQuantity && p.getStockQuantity() <= maxQuantity) {
                result.add(p);
            }
        }
        return result;
    }

    
}
