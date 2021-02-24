package Project;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;



public class Customer {
    private String id;
    private String address;
    private int money;
    //private ArrayList<Order> orderList = new ArrayList<Order>();
    private ArrayList<String> foodlist = new ArrayList<String>();
    
    public Customer() {
    	
    }
    public Customer(String id, String address) {
       this.id = id;
       this.address = address;
       this.money = 100000;
       
    }
    
    // 메뉴추가하기 메인에서 파라미터 받아서 넣는다
    public void setMenu(String foodName, int price) {
    	
    	Food f = new Food(foodName, price);
    	foodlist.add(f.toString());
    	
    	String filePath = "C:\\Temp\\Menu.txt";
    	
        FileOutputStream fos=null;
        BufferedOutputStream bos = null;
        ObjectOutputStream out =null;
        try {
        	
        	// 직렬화한 객체를 C:\\Temp\\Menu.txt에 저장하기로 경로 잡는다
            fos = new FileOutputStream(filePath);
            bos = new BufferedOutputStream(fos);
            out = new ObjectOutputStream(bos); //분해된 부품을 조립 (역지렬화)
            
            // foodlist를 직렬화해서 저장
            out.writeObject(foodlist);
            
        }catch (Exception e) {
        }finally {
            try {
                out.close();
                bos.close();
                fos.close();
            } catch (Exception e) {
                
            }
        }
    	
    }
    
    //메뉴판 보기 
    public void getMenu() {
    	
    	// 아래 경로에 있는 파일에 저장한 객체를 불러온다
        String filePath = "C:\\Temp\\Menu.txt";
	
        FileInputStream fis=null;
        BufferedInputStream bis = null;
        ObjectInputStream in =null;
        try {
            fis = new FileInputStream(filePath);
            bis = new BufferedInputStream(fis);
            in = new ObjectInputStream(bis); //분해된 부품을 조립 (역직렬화)
            
            Object foods = null;
            
            // foods에 재조립한 객체가 담겼다
            foods = in.readObject();
            System.out.println(foods);

        }catch (Exception e) {
              System.out.println(e.getMessage());

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
    	
    	// 장바구니 담는 것처럼 선택한 주문 누적할 것
    	String str = "";
    	
    	// switch문 써도 되지만 그러면 case가 늘어날 때마다 수정해줘야 할 것 같아서
    	// arraylist에 메뉴를 담고 choice는 리스트의 인덱스를 가리키게 했다
    	while(true) {
    		
    		System.out.println("주문하실 메뉴를 선택해주세요. ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
    		
            // foodlist에 담긴 메뉴가 늘어나도 상관 없게 조건식 설정
    		if(choice <= foodlist.size() && choice > 0) {  			
    			
    			str += foodlist.get(choice-1)+"\n";
                System.out.println(str);
                
    		} else {
    			System.out.println("잘못 입력하셨습니다.");
    		}    		   		
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
    
   /* 
    public String toString() {
        return null;
    }
    */
}