package Computer;

import java.util.Scanner;

public class Computer {
    private int price; //가격
    private int number; //시리얼 넘버
    private String brand; //브랜드
    private String color; //색깔
    
    public Computer(int price, int number, String brand, String color) {
        this.price = price;
        this.number = number;
        this.brand = brand;
        this.color = color;
   }
    
    boolean lowMode;
    String space;
    
    MainBody mainbody = new MainBody();
    Monitor monitor = new Monitor();
    Keyboard keyboard = new Keyboard();
    public Scanner scanner = new Scanner(System.in);
    
    //공간 ( space ) 에 입력, 출력
    public void setSpace() {
        System.out.print("입력하실 내용 > ");
        scanner.nextLine();
        this.space = scanner.nextLine();
    }
    public void PrintSpace() {
        System.out.println("출력 내용: ");
        System.out.println(this.space);
    }
    
    //컴퓨터 전원 키고, 끄기
    public void ComputerOn() {
        System.out.println("컴퓨터의 전원을 킵니다.");
        mainbody.power = true;
    }
    public void ComputerOff() {
        System.out.println("컴퓨터의 전원을 끕니다.");
        mainbody.power = false;
    }
    
    //절전모드 키고, 끄기
    public void lowModeOn() {
        System.out.println("절전모드를 실행합니다.");
        lowMode = true;
    }
    public void lowModeOff() {
        System.out.println("절전모드를 종료합니다.");
        lowMode = false;
    }
    
    //사칙연산 기능
    public void calculate(int i, int j) {
        System.out.println("연산자를 선택해주세요. \n (덧셈: 1, 뺄셈: 2, 곱셈: 3, 나눗셈: 4)");
        int choice = scanner.nextInt();
        switch(choice) {
        case 1:
            add(i,j);
            break;
        case 2:
            min(i,j);
            break;
        case 3:
            mul(i,j);
            break;
        case 4:
            div(i,j);
            break;
        default :
            System.out.println("잘못입력하셨습니다.");

        }
    }
    
    private void add(int i, int j) {
        System.out.printf("%d + %d = %d\n" ,i , j , i+j);
    }
    private void min(int i, int j) {
        System.out.printf("%d - %d = %d\n" ,i , j , i-j);
    }
    private void mul(int i, int j) {
        System.out.printf("%d * %d = %d\n" ,i , j , i*j);
    }
    private void div(int i, int j) {
        System.out.printf("%d / %d = %f\n" ,i , j , (float)i/j);
    }
     
    //컴퓨터 상태, 정보 보기
    public void ComputerInfo() {
        System.out.println("-- 컴퓨터 상태 --");
        System.out.println("전원 : " + mainbody.power);
        System.out.println("절전모드 : " + lowMode);
        System.out.println("-- 컴퓨터 정보 --");
        System.out.println("가격: " + price + "원");
        System.out.println("시리얼 넘버: " + number);
        System.out.println("브랜드: " + brand);
        System.out.println("색깔: " + color);
    }
}
