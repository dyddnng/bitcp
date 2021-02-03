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
    
    int lowMode;
    //boolean lowMode; //절전모드 여부
    String space; // 

    MainBody mainbody = new MainBody();
    Monitor monitor = new Monitor();
    Keyboard keyboard = new Keyboard();
    public Scanner scanner = new Scanner(System.in);
    
    // 컴퓨터 전원 켜기
    public void ComputerOn() {
    	System.out.println("시스템을 실행할까요? 실행:1 종료:0");
    	mainbody.power = scanner.nextInt();
        while(true) {
        	if(mainbody.power == 1) {
        		System.out.println("시스템을 시작합니다.");
        		break;
        	} else if(mainbody.power == 0) {
        		System.out.println("시스템을 종료합니다.");
        		break;
        	}
        	System.out.println("잘못입력하셨습니다.");
        	System.out.println("시스템을 실행할까요? 실행:1 종료:0");
        	mainbody.power = scanner.nextInt();
        }
    }


    //공간 ( space ) 에 입력, 출력
    public void setSpace() {
        System.out.print("입력하실 내용 > ");
        scanner.nextLine();
        this.space = scanner.nextLine();
        System.out.println(this.space);
    }
    
    //절전모드 켜고, 끄기   
    public void lowMode() {
    	System.out.println("절전모드를 실행할까요? 실행:1 종료:0");
    	lowMode = scanner.nextInt();
        while(true) {
        	if(lowMode == 1) {
        		System.out.println("절전모드를 실행합니다.");
        		break;
        	} else if(lowMode == 0) {
        		System.out.println("절전모드를 종료합니다.");
        		break;
        	}
        	System.out.println("잘못입력하셨습니다.");
        	System.out.println("절전모드를 실행할까요? 실행:1 종료:0");
        	lowMode = scanner.nextInt();
        }
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
        if(mainbody.power == 1) {
        	System.out.println("전원 ON");
        } else {
        	System.out.println("전원 OFF");
        }
        if(lowMode == 1) {
        	System.out.println("절전모드 실행중");
        } else {
        	System.out.println("절전모드 꺼짐");
        }
        
        System.out.println("-- 컴퓨터 정보 --");
        System.out.println("가격: " + price + "원");
        System.out.println("시리얼 넘버: " + number);
        System.out.println("브랜드: " + brand);
        System.out.println("색깔: " + color);
    }
    
    public static void main(String[] args) {
    	
    	
    	// 컴퓨터를 써봅시다
    	Computer computer = new Computer(100,33,"SAMSTAR","black");
    	
    	// 전원 on-off 가능
    	computer.ComputerOn();
    	
    	// 입출력이 가능
    	computer.setSpace();
    	   	
    	// 절전모드 on-off 가능
    	computer.lowMode();
    	
    	// 사칙연산
    	computer.calculate(1, 5);
    	
    	// 컴퓨터 상태 보기
    	computer.ComputerInfo();
    	
    	
    }
}



