package BitEats;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BitEats2 {
	
	public Scanner scanner = new Scanner(System.in);
	private Map<String, String> users;
	private List<Customer2> customerlist;
	private List<Seller> sellerlist;
	private List<Order> orderlist;
	
	public BitEats2(){
		users = new HashMap<String, String>();
		customerlist = new ArrayList<Customer2>();
		sellerlist = new ArrayList<Seller>();
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
				break;
				
				
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
					
				}
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
			
		}
		
		
	}
	
	public void login() {
		
		while(true) {
			System.out.println("ID를 입력해주세요.");
			String id = scanner.nextLine().trim().toLowerCase();
			System.out.println("PW를 입력해주세요.");
			String pw = scanner.nextLine().trim();
			
			if(!users.containsKey(id)) {
				System.out.println("존재하지 않는 아이디입니다. 다시 입력해주세요.");
			} else {
				if(users.get(id).equals(pw)) {
					System.out.println("로그인되었습니다.");
					break;
				}else {
					System.out.println("비밀번호가 맞지 않습니다.");
				}
			}
			
			
		}
		
	}
	
	
	
	public void order(boolean order) {
		
		if(order == true) {
			System.out.println("주문이 승인되었습니다.");
			
		} else {
			System.out.println("주문이 취소되었습니다");
		}
		
		
	}
	

}
