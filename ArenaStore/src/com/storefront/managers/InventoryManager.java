package com.storefront.managers;

import java.util.ArrayList;
import java.util.List;

import com.storefront.models.SalableProduct;

public class InventoryManager {
    private List<SalableProduct> products = new ArrayList<>();
    
    public void addProduct(SalableProduct product) {
        products.add(product);
    }

    public void removeProduct(String productName) {
        products.removeIf(product -> product.getName().equalsIgnoreCase(productName));
    }

    public SalableProduct getProductByName(String name) {
        for (SalableProduct product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public List<SalableProduct> getProducts() {
        return new ArrayList<>(products);
    }
}
