public class Item {
    private final String itemID;
    private final String itemName;
    private final double price;
    private final double expectedWeight;

    public Item(String itemID, String itemName, double price, double expectedWeight) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.price = price;
        this.expectedWeight = expectedWeight;
    }
    public String getItemID() { return itemID; }
    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public double getExpectedWeight() { return expectedWeight; }
}
