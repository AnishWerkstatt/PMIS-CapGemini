package org.example.coupling.testing;

public class OrderValidator {
    public boolean isValid(String product) {
        // Because the validator creates RealInventory here, a test cannot
        // replace it with a fast fake inventory. Injection will fix this.
        RealInventory inventory = new RealInventory();
        return inventory.hasStock(product);
    }
}
