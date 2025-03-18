package com.storefront.managers;

import java.util.ArrayList;
import java.util.List;

import java.util.Comparator;

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
    
    /** Sort inventory by product name */
    public void sortByName() {
        products.sort(Comparator.comparing(SalableProduct::getName));
    }

    /** Sort inventory by product price */
    public void sortByPrice() {
        products.sort(Comparator.comparingDouble(SalableProduct::getPrice));
    }

    /** Sort inventory by product quantity */
    public void sortByQuantity() {
        products.sort(Comparator.comparingInt(SalableProduct::getQuantity));
    }
}
