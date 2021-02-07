package Person;

public class Person {
    private int height;
    private int width;
    private int ticketNumber;

    public Person(int height, int width, int ticketNumber) {
       this.height = height;
       this.width = width;
       this.ticketNumber = ticketNumber;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getTicketNumber() {
        return this.ticketNumber;
    }
    
    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
    
    public void printSeatInfo() {
        System.out.printf("고객님이 예매하신 좌석은 [%d-%d] 입니다.\n", height, width);
    }

}