package it.unibo.collections.design;

import java.util.LinkedHashSet;
import java.util.Set;

import it.unibo.collections.design.api.*;

public class WarehouseImpl implements Warehouse {

    public final LinkedHashSet<Product> products;

    public WarehouseImpl() {
        products = new LinkedHashSet<>();
    }

    public void addProduct(final Product p) {
        this.products.add(p);
    }

    @Override
    public Set<String> allNames() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<Product> allProducts() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean containsProduct(Product p) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public double getQuantity(String name) {
        // TODO Auto-generated method stub
        return 0;
    }

}