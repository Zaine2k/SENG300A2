import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ProductDatabase {
    private static volatile ProductDatabase instance;
    private final Map<String, Item> products = new HashMap<>();

    private ProductDatabase() {}

    public static ProductDatabase getInstance() {
        if (instance == null) {
            synchronized (ProductDatabase.class) {
                if (instance == null) instance = new ProductDatabase();
            }
        }
        return instance;
    }

    public void addProduct(Item item) { products.put(item.getItemID(), item); }
    public Item getById(String id) { return products.get(id); }
    public Map<String, Item> viewAll() { return Collections.unmodifiableMap(products); }
}
