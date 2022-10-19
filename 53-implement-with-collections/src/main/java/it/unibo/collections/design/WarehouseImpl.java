package it.unibo.collections.design;

import java.util.LinkedHashSet;
import java.util.*;

import it.unibo.collections.design.api.*;

public class WarehouseImpl implements Warehouse {

    private static final int PRODUCT_NOT_FOUND = -1;

    public final LinkedHashSet<Product> products;

    public WarehouseImpl() {
        products = new LinkedHashSet<>();
    }

    public void addProduct(final Product p) {
        this.products.add(p);
    }

    public Set<String> allNames() {

        if (this.products.isEmpty()) {
            return null;
        }

        final Set<String> names = new TreeSet<>();
        for (Product p : this.products) {
            names.add(p.getName());
        }

        return names;
    }

    public Set<Product> allProducts() {
        return Set.copyOf(this.products);
    }

    public boolean containsProduct(final Product p) {
        return this.products.contains(p);
    }

    public double getQuantity(final String name) {
        for (Product p : this.products) {
            if (p.getName() == name) {
                return p.getQuantity();
            }
        }

        return PRODUCT_NOT_FOUND;
    }

}