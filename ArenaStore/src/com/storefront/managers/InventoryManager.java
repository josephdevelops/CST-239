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
    
    /** Sort inventory by product name with order option */
    public void sortByName(boolean ascending) { // Modified: added boolean parameter
        if (ascending) {
            products.sort(Comparator.comparing(SalableProduct::getName));
        } else {
            products.sort(Comparator.comparing(SalableProduct::getName).reversed());
        }
    }

    /** Sort inventory by product price with order option */
    public void sortByPrice(boolean ascending) { // Modified: added boolean parameter
        if (ascending) {
            products.sort(Comparator.comparingDouble(SalableProduct::getPrice));
        } else {
            products.sort(Comparator.comparingDouble(SalableProduct::getPrice).reversed());
        }
    }

    /** Sort inventory by product quantity with order option */
    public void sortByQuantity(boolean ascending) { // Modified: added boolean parameter
        if (ascending) {
            products.sort(Comparator.comparingInt(SalableProduct::getQuantity));
        } else {
            products.sort(Comparator.comparingInt(SalableProduct::getQuantity).reversed());
        }
    }
}