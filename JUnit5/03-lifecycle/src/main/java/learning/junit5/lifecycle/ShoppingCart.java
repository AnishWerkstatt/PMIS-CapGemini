package learning.junit5.lifecycle;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<String> items = new ArrayList<>();

    public void add(String item) {
        items.add(item);
    }

    public int itemCount() {
        return items.size();
    }

    public void clear() {
        items.clear();
    }
}
