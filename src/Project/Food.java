package Project;

public class Food {
    private String foodName;
    private int foodPrice;

    public Food(String foodName, int price) {
        this.foodName = foodName;
        this.foodPrice = price;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getPrice() {
        return foodPrice;
    }

    @Override
    public String toString() {
        return this.foodName;
    }
}
