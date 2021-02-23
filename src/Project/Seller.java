package Project;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*

판매자

판매자는 주문을 확인할 수 있다.
판매자는 주문을 승인 또는 거절할 수 있다.
판매자는 메뉴를 추가,제거할 수 있다.
판매자는 배달 소요 시간을 지정할 수 있다.
판매자는 판매 내역을 볼 수 있다.
판매자는 가게 Open, Close 를 할 수 있다.
 */
public class Seller {
    private boolean open;
    private String storeName;
    private ArrayList<Food> menu;
    private ArrayList<Order> orderList;
////////주문 내역 확인 역순으로 할까? 그건 다 만든다음에 고민해보기//////////
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

            Object orders = null;

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

    //가게 열기 닫기
    public boolean open() {
        return !open;
    }
}
