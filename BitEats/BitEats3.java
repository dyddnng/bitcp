package BitEats;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BitEats3 {
	
	public Scanner scanner = new Scanner(System.in);
	private HashMap<String, String> users;
	private ArrayList<Customer2> customerlist;
	private ArrayList<Seller> sellerlist;
	private ArrayList<Order> orderlist;
	
	// 0이면 로그아웃, 1이면 개인, 2면 가맹
	private int status;
	
	public BitEats3(){
		users = new HashMap<String, String>();
		customerlist = new ArrayList<Customer2>();
		sellerlist = new ArrayList<Seller>();
		orderlist =  new ArrayList<Order>();
		this.status = 0;
	}
	
	public void join() {
		
		while(true) {
			System.out.println("개인 회원가입은 1, 가맹 회원 가입은 2를 입력해주세요.");
			int usertype = scanner.nextInt();
			
			if( usertype == 1) {
				
				System.out.println("아이디를 입력해주세요.");
				scanner.nextLine();
				String idinput = scanner.nextLine().trim().toLowerCase();
				String id = "c"+idinput;
				
				System.out.println("비밀번호를 입력해주세요.");
				String pw = scanner.nextLine();
				
				users.put(id, pw);
				
				break;
	
			} else if( usertype == 2) {
				System.out.println("아이디를 입력해주세요.");
				scanner.nextLine();
				String idinput = scanner.nextLine().trim().toLowerCase();
				String id = "s"+idinput;
				
				System.out.println("비밀번호를 입력해주세요.");
				String pw = scanner.nextLine().trim();
				
				users.put(id, pw);
				
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
			
			if(users.containsKey("c"+id)){
				
				if(users.get("c"+id).equals(pw)) {
					System.out.println("로그인되었습니다.");
					
					System.out.println("개인회원입니다.");
					System.out.println(id);
					System.out.println(pw);
					status = 1;
						
					break;
						
				} else {
					System.out.println("비밀번호가 맞지 않습니다.");
				}
			
			} else if(users.containsKey("s"+id)) {
				
				if(users.get("s"+id).equals(pw)) {
					System.out.println("로그인되었습니다.");
					
					System.out.println("가맹회원입니다.");
					System.out.println(id);
					System.out.println(pw);
					status = 2;
						
					break;
						
				} else {
					System.out.println("비밀번호가 맞지 않습니다.");
				}
				
			}else{
				System.out.println("존재하지 않는 아이디입니다. 다시 입력해주세요.");			
			} 
			
		}
		order(status);
		
	}
	
	
	
	public void order(int status) {
		
		/*
		if( status == 1 ) {

			if(order == true) {
				System.out.println("주문이 승인되었습니다.");
				
			} else {
				System.out.println("주문이 취소되었습니다");
			}
		} else if( status == 2){
			System.out.println("권한이 없습니다.");
		} else {
			System.out.println("로그아웃 상태입니다. 로그인 먼저 해주세요.");
		}
		*/
		

		if( status == 1 ) {

				System.out.println("주문이 승인되었습니다.");

		} else if( status == 2){
			System.out.println("권한이 없습니다.");
			
		} else {
			
			System.out.println("로그아웃 상태입니다. 로그인 먼저 해주세요.");
		}
		
		
	}

	

}
