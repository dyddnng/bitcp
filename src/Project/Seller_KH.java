package BitEats3;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Seller_KH implements Serializable {
    private boolean open;
    private String storeName;
    private ArrayList<Food> menu;
    private ArrayList<Order> orderList;
    private Scanner scanner = new Scanner(System.in);

////////주문 내역 확인 역순으로 할까? 그건 다 만든다음에 고민해보기//////////

    Seller_KH(String storeName) {
        this.open = false;
        this.storeName = storeName;
        this.menu = new ArrayList<Food>();
        this.orderList = new ArrayList<Order>();
    }
    
    public void sellerMenu() {
    	while(true) {
			
			System.out.println("************비트이츠에 오신 것을 환영합니다************");
	        System.out.println("이용을 원하시는 메뉴를 선택해주세요.");
	        System.out.println("1.주문내역확인 2. 메뉴선택");
	        System.out.println("***********************************************");
	        int menu = scanner.nextInt();
	        switch(menu) {
	        case 1: checkOrders();
	        	break;
	       // case 2: permission();
	        	//break;
	        default: System.out.println("잘못 선택하셨습니다.");
	        }
		}
    }

    //주문 내역 확인
    public void checkOrders() {
        // I/O 로 파일 불러옴 파일이름은 storeName과 동일하다

        String baseFileFolder = "C:\\BitEats\\Orders\\SellerOrder"; //기본 경로
        String filename = baseFileFolder + "\\" + this.storeName + ".txt";

        FileInputStream fis = null;
        BufferedInputStream bis = null;
        ObjectInputStream in = null;

        try {
            fis = new FileInputStream(filename); //파일이름불러오고
            bis = new BufferedInputStream(fis); //불러온걸 버퍼로옮기고
            in = new ObjectInputStream(bis); //버퍼로 옮긴걸 조립한다

            Object orders = null;  ///////////orders.으로 객체 기능 사용가능하다//////////

            while ((orders = in.readObject()) != null) {

                System.out.println((Order)orders);
            }

        } catch (FileNotFoundException fn) {
            System.out.println("파일이 존재하지 않습니다");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        } finally {
            try {
                in.close();
                bis.close();
                fis.close();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        //permission(order);
    }
    //주문승인 or 거절
    public void permission(Order o) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(this.storeName + " 주문관리 시스템입니다. \n주문이 들어왔습니다.");
        System.out.println(o);
        System.out.println("주문번호 " + o.getOrderNum() + "번을 승인하시려면 1, 취소하시려면 2를 입력해주세요");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 :
                System.out.println("주문번호 " + o.getOrderNum() + "번을 승인했습니다.");
                o.setPermission(true);
                scanner.close();
                break;
            case 2 :
                System.out.println("주문번호 " + o.getOrderNum() + "번을 거절했습니다.");
                o = null; //이렇게되나???
                scanner.close();
                break;
        }
    }
    //menu에 Food 추가
    public void addFood() {

        Scanner scanner = new Scanner(System.in);

        System.out.println(this.storeName + " 메뉴 추가 시스템입니다.");
        System.out.println("추가하실 음식 이름을 알려주세요.");
        String foodName = scanner.nextLine();
        System.out.println("음식 가격을 입력해주세요");
        int foodPrice = scanner.nextInt();
        scanner.nextLine();
        menu.add(new Food(foodName, foodPrice));
    }
    //메뉴 확인
    public void showMenu() {
        for(int i = 0 ; i < menu.size() ; i ++) {
            System.out.printf("메뉴 [%d] : %s | %d원\n" , i + 1 , menu.get(i).getFoodName(), menu.get(i).getPrice());
        }
    }
    //메뉴 지우기(수정)
    public void deleteMenu () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("========== 현재 메뉴 목록 ==========");
        showMenu();
        System.out.println("몇 번 메뉴를 삭제하시겠습니까?");
        int choice = scanner.nextInt();
        System.out.println(menu.remove(choice - 1) + "를 삭제했습니다.");
        System.out.println("========== 현재 메뉴 목록 ==========");

        showMenu();

        scanner.close();
    }

    //가게 열기 닫기
    public boolean open() {
        return !open;
    }
}