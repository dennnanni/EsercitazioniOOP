package it.unibo.collections.design;

import java.util.*;

import it.unibo.collections.design.api.Product;

public class OrderedWarehouse extends WarehouseImpl {
    
    public Set<Product> allProducts() {
        return new TreeSet<Product>(super.allProducts());
    }
}
