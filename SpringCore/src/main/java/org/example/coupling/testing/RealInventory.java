package org.example.coupling.testing;

public class RealInventory {
    public boolean hasStock(String product) {
        // Pretend this calls a database or remote inventory service.
        // A unit test should not need that external system.
        System.out.println("Checking the real inventory system.");
        return true;
    }
}
