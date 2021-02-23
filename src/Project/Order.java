package Project;

public class Order {
    private Food food; //
    private String user; // User에서 이름만(ID)
    private String seller; //Seller에서 이름만(ID)

    public Order(Food food, String users, String sellers) {
        this.food = food;
        this.user = users;
        this.seller = sellers;
    }
}
