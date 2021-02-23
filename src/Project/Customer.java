package Project;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;


public class Customer {
    private String id;
    private String address;
    private int money;
    //private ArrayList<Order> orderList = new ArrayList<Order>();
    
    public Customer(String id, String address) {
       this.id = id;
       this.address = address;
       this.money = 100000;
       
    }
    
    //메뉴판 보기 
    public void getMenu() {
        String filePath = "/Users/joohyun/java_test/Menu.txt";
        
        FileInputStream fis=null;
        BufferedInputStream bis = null;
        ObjectInputStream in =null;
        try {
            fis = new FileInputStream(filePath);
            bis = new BufferedInputStream(fis);
            in = new ObjectInputStream(bis); //분해된 부품을 조립 (역지렬화)
            
            Object  users =null;
            while((users = in.readObject()) != null) {
                System.out.println(((Food)users).toString());
            }
        }catch (FileNotFoundException fnfe) {
              System.out.println("파일이 존재하지 않습니다");
        }catch (EOFException eofe) {
              System.out.println("끝" + eofe.getMessage());
        }catch (IOException ioe) {
              System.out.println(ioe.getMessage());
        }catch (ClassNotFoundException cnfe) {
               System.out.println(cnfe.getMessage());
        }finally {
            try {
                in.close();
                bis.close();
                fis.close();
            } catch (Exception e) {
                
            }
        }
    }
    
    //주문하기 
    public void order() {
        
        System.out.println("주문하실 메뉴를 선택해주세요. ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        
        switch(choice) {
        case 1: 
        case 2:
        case 3:
        case 4:
        default: System.out.println("잘못 입력하셨습니다. ");
            break;
        }
        
    }
    
    //결제하기 
    public void pay(Food f) {
        
        if(f.getPrice() >= this.money) {
            System.out.println("주문 불가 ! 돈이 부족합니다... 잔액은 :" +this.money+ "입니다. " );
        }
        //돈 있음 
        money -= f.getPrice();
        System.out.println("결제 완료 !");
    }
    
    
    public String toString() {
        return null;
    }
    
}
