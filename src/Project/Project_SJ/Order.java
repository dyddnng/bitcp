package Project_SJ;

public class Order {
    private int orderNum; //아니잠간.. orderNum이 정상적으로 누적되려면. I/O를 써야하잖아????
    private boolean permission;
    private Food food; // Food가져야지..
    private String user; // User에서 이름만(ID)
    private String seller; //Seller에서 이름만(ID)

    public int getOrderNum() {
        return orderNum;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }



    public Order(Food food, String users, String sellers) {
        this.food = food;
        this.user = users;
        this.seller = sellers;
        this.permission = false;
    }
}
