package BitEats3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import BitEats3.Customer_KH;


public class BitEats_KH implements Serializable {
	
	private Scanner scanner = new Scanner(System.in);
	private Map<String, String> users;
	private List<Customer_KH> customerlist;
	private List<Seller_KH> sellerlist;
	private List<Order> orderlist;
	
	public BitEats_KH(){
		users = new HashMap<String, String>();
		customerlist = new ArrayList<Customer_KH>();
		sellerlist = new ArrayList<Seller_KH>();
		orderlist =  new ArrayList<Order>();
	}
	
	
	
	public void join() {
		while(true) {
			System.out.println("개인 회원가입은 1, 가맹 회원 가입은 2를 입력해주세요.");
			int usertype = scanner.nextInt();
			
			if( usertype == 1) {
				
				System.out.println("아이디를 입력해주세요.");
				scanner.nextLine();
				String id = scanner.nextLine();
				
				System.out.println("비밀번호를 입력해주세요.");
				String pw = scanner.nextLine();
				
				users.put(id, pw);
				
				String customers = "C:\\BitEats\\Users\\Customers.txt"; // 객체를 직렬화해 write
				
				FileOutputStream fos = null;
				BufferedOutputStream bos = null;
				ObjectOutputStream oos = null;
				
				try {
					
					fos = new FileOutputStream(customers, true); //append
					bos = new BufferedOutputStream(fos);
					oos = new ObjectOutputStream(bos); // 직렬화
					 
					oos.writeObject(users); // 분해해서 "Customer.txt"에 쓴다
					
			
				} catch (Exception e) {

					e.printStackTrace();
					
				} finally{
					
					try {
						
						bos.close();
	    				oos.close();
	    				fos.close();
	    				
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
				}
				
				System.out.println("가입이 완료되었습니다.");
				Customer_KH customer = new Customer_KH();
				customer.customerMenu();

				
			} else if( usertype == 2) {
				System.out.println("아이디를 입력해주세요.");
				scanner.nextLine();
				String id = scanner.nextLine().trim().toLowerCase();
				
				System.out.println("비밀번호를 입력해주세요.");
				String pw = scanner.nextLine().trim();
				
				users.put(id, pw);
				
				String sellers = "C:\\BitEats\\Users\\Sellers.txt"; // 객체를 직렬화해 write
				
				FileOutputStream fos = null;
				BufferedOutputStream bos = null;
				ObjectOutputStream oos = null;
				
				

				try {
					
					fos = new FileOutputStream(sellers, true);
					bos = new BufferedOutputStream(fos);
					oos = new ObjectOutputStream(bos);
					 
					oos.writeObject(users); 
					
			
				} catch (Exception e) {

					e.printStackTrace();
					
				} finally{
					
					try {
						
						bos.close();
	    				oos.close();
	    				fos.close();
	    				
					} catch (Exception e2) {
						// TODO: handle exception
					}
					System.out.println("가입이 완료되었습니다.");
					Seller_KH seller = new Seller_KH(id);
					seller.sellerMenu();
				}
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
			
		}
				
	}
	
	public void login() {
		
		System.out.println("ID를 입력해주세요.");
		String idinput = scanner.nextLine().trim().toLowerCase();
		System.out.println("PW를 입력해주세요.");
		String pw = scanner.nextLine().trim();
		
		while(true) {
			
			
		}
		
	}
	
	
	
	public void order(boolean order) {
		
		if(order == true) {
			System.out.println("주문이 승인되었습니다.");
			
		} else {
			System.out.println("주문이 취소되었습니다");
		}
		
		
	}
	
	
	public void BitEatsMain() {
		
		while(true) {
			
			System.out.println("************비트이츠에 오신 것을 환영합니다************");
	        System.out.println("1을 입력하시고 회원가입을 진행해주세요.\n이미 회원이신가요?\n2를 입력해 로그인 해주세요.");
	        System.out.println("***********************************************");
	        int premenu = scanner.nextInt();
	        switch(premenu) {
	        case 1: join();
	        	break;
	        case 2: login();
	        	break;
	        default: System.out.println("비트이츠를 이용하시려면 로그인을 해주세요!");
	        }
		}
        
	}

}
