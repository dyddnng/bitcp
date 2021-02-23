package BitEats2;

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



public class Customer_2 {
    private String id;
    private String address;
    private int money;
    //private ArrayList<Order> orderList = new ArrayList<Order>();
    private ArrayList<String> foodlist = new ArrayList<String>();
    
    public Customer_2() {
    	
    }
    public Customer_2(String id, String address) {
       this.id = id;
       this.address = address;
       this.money = 100000;
       
    }
    
    // 메뉴추가하기 메인에서 파라미터 받아서 넣는다
    // 이렇게 넣은 거 직렬화까진 되는데 역직렬화가....잘....되나?
    public void setMenu(String foodName, int price) {
    	
    	Food f = new Food(foodName, price);
    	foodlist.add(f.toString());
    	
    	String filePath = "C:\\Temp\\Menu.txt";
        
        FileOutputStream fos=null;
        BufferedOutputStream bos = null;
        ObjectOutputStream out =null;
        try {
            fos = new FileOutputStream(filePath);
            bos = new BufferedOutputStream(fos);
            out = new ObjectOutputStream(bos); //분해된 부품을 조립 (역지렬화)
            

            for(int i = 0; i < foodlist.size(); i++) {
            	out.writeObject(foodlist);
            }
            
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
        String filePath = "C:\\Temp\\Menu.txt";
        
        FileInputStream fis=null;
        BufferedInputStream bis = null;
        ObjectInputStream in =null;
        try {
            fis = new FileInputStream(filePath);
            bis = new BufferedInputStream(fis);
            in = new ObjectInputStream(bis); //분해된 부품을 조립 (역직렬화)
            
            Object foods = null;
            
            foods = in.readObject();
            System.out.println(foods.toString());
            
            /*
            while((foods = in.readObject()) != null) {
                System.out.println(foods.toString());
                //foodlist.add(foods.toString());
            }
            */

            
            
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
    	String str = "";
    	while(true) {
    		
    		System.out.println("주문하실 메뉴를 선택해주세요. ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
    		
    		if(choice <= foodlist.size() && choice > 0) {
    			
    			
    			str += foodlist.get(choice-1);

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