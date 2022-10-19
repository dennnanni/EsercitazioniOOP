package it.unibo.collections.design;

import it.unibo.collections.design.api.Product;

public class ComparableProduct extends ProductImpl implements Comparable<Product> {

    public ComparableProduct(final String name, final double quantity) {
        super(name, quantity);
    }

    public int compareTo(final Product arg0) {
        
        return this.getName().compareTo(arg0.getName());
    }
}
