package Computer;

import java.util.Scanner;

public class Computer {
    private int price; //가격
    private int number; //시리얼 넘버
    private String brand; //브랜드
    private String color; //색깔
    
    boolean lowMode;
    String space;
    
    MainBody mainbody = new MainBody();
    Monitor monitor = new Monitor();
    Keyboard keyboard = new Keyboard();
    Scanner scanner = new Scanner(System.in);
    
    //공간 ( space ) 에 입력, 출력
    public void SpaceInput() {
        this.space = scanner.nextLine();
    }
    public void SpacePrint() {
        System.out.println(this.space);
    }
    
    //컴퓨터 전원 키고, 끄기
    public void ComputerOn() {
        mainbody.power = true;
    }
    public void ComputerOff() {
        mainbody.power = false;
    }
    
    //절전모드 키고, 끄기
    public void lowModeOn() {
        lowMode = true;
    }
    public void lowModeOff() {
        lowMode = false;
    }
    
    public double calculate(double i, double j) {
        return i;
    }
}
