package Project;

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

import Project.Customer;


public class BitEats implements Serializable {
    
    private Scanner scanner = new Scanner(System.in);
    private Map<String, String> users;
    private List<Customer> customerlist;
    private List<Seller> sellerlist;
    private List<Order> orderlist;
    
    public BitEats(){
        users = new HashMap<String, String>();
        customerlist = new ArrayList<Customer>();
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
                
                System.out.println("가입이 완료되었습니다.");
                Customer customer = new Customer();
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
                    Seller seller = new Seller(id);
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
            /*
            System.out.println("ID를 입력해주세요.");
            String idinput = scanner.nextLine().trim().toLowerCase();
            System.out.println("PW를 입력해주세요.");
            String pw = scanner.nextLine().trim();
            
            String path = "C:\\BitEats\\Users";
            String id = idinput;
            String type = "type.txt";
    
            try {
                
                File file = new File(path);
                
                PrintWriter writer = new PrintWriter(new FileWriter(type));
                BufferedReader br = null;
                
                File[] files = file.listFiles();
                for(int i = 0; i < files.length; i++) {
                    br = new BufferedReader(new FileReader(files[i]));
                    
                    String str = "";
                    String typefile = "";
                    while( (str = br.readLine()) != null ) {
                        if(str.indexOf(id) != -1) {
                            
                            typefile = writer.toString();
                        }
                    }
                }
        
                br.close();
                writer.close();
                
            } catch (Exception e) {
                // TODO: handle exception
            }


                */
                
            
            
            /*
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
            */
            
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
