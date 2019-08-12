package chap12_Enums_Annotations;

// Use an emun constructor, instance variable and method
public enum Apple {
    Jonathan(10), GoldenDel(9), RedDel(12),
    Winesap(15), Cortland(8);
    private int price; // price of each apple

    // Constructor
    Apple(int price) {
        this.price = price;
    }

    // Overloaded constructor
    Apple() {
        price = -1;
    }

    public int getPrice() {
        return price;
    }
}
