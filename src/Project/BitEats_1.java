package Project;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BitEats_1 {
    private Map<String, String> users;
    private List<Order> ordersList;
    private Scanner scanner;
    private FileOutputStream fos;
    private BufferedOutputStream bos;
    private ObjectOutputStream oot;
    private FileInputStream fis;
    private BufferedInputStream bis;
    private ObjectInputStream oit;
    private final String USERINFO = "C:\\Temp";

    public BitEats_1() {
        users = new HashMap<String, String>();
        ordersList = new ArrayList<Order>();
        scanner = new Scanner(System.in);
    }

    public boolean join() {
        System.out.println("가입자 유형을 입력해주세요 (소비자:\'1\', 판매자:\'2\'");
        System.out.println("소비자일 경우 \'S\', 판매자일 경우 \'C\' 가 아이디 맨 앞에 자동으로 붙습니다");
        System.out.println("> ");
        int type = scanner.nextInt();

        System.out.println("가입할 아이디를 입력해주세요 (소문자)");
        System.out.print("> ");
        scanner.nextLine();
        String id = scanner.nextLine().trim().toLowerCase();

        System.out.println("가입할 비밀번호를 입력해주세요");
        System.out.print("> ");
        String pwd = scanner.nextLine();

        if (users.containsKey(id) || users.containsValue(pwd)) {
            System.out.println("이미 존재하는 아이디거나 비밀번호입니다.");
            return false;
        }

        if (!(type == 1 || type == 2)) {
            System.out.println("사용자 유형을 잘못입력하셨습니다.");
            return false;
        } else if (type == 1) {
            try {
                fos = new FileOutputStream(USERINFO, true);
                bos = new BufferedOutputStream(fos);
                oot = new ObjectOutputStream(bos);// 직렬화 끝
                //직렬화 대상
                System.out.println("주소를 입력해 주세요.");
                String address = scanner.nextLine();
                oot.writeObject(new Customer(id,"bit시 bit동"));
                users.put("C" + id, pwd);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    oot.close();
                    bos.close();
                    oot.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        } else if (type == 2) {
            try {
                fos = new FileOutputStream(USERINFO, true);
                bos = new BufferedOutputStream(fos);
                oot = new ObjectOutputStream(bos);
                Seller test = new Seller(id);
                oot.writeObject(test);// 완성!!
                users.put("S" + id, pwd);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    oot.close();
                    bos.close();
                    oot.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        return true;
    }

    public boolean login() {
        boolean isLogin;
        System.out.println("아이디를 입력해주세요");
        System.out.print("> ");
        String id = scanner.nextLine();

        System.out.println("비밀번호를 입력해주세요");
        System.out.print("> ");
        String pwd = scanner.nextLine();

        if (!users.containsKey(id)) {
            System.out.println("존재하지 않는 아이디입니다. 다시 입력해주세요.");
            isLogin = false;
        } else {
            if (users.get(id).equals(pwd)) {
                System.out.println("로그인되었습니다.");
                isLogin = true;
            } else {
                System.out.println("비밀번호가 맞지 않습니다.");
                isLogin = false;
            }
        }
        if (isLogin) {
            try {
                fis = new FileInputStream(USERINFO);// C:\\BitEats\\User\\Customer\\id.txt
                bis = new BufferedInputStream(fis);
                oit = new ObjectInputStream(bis);

                if(id.charAt(0) == 'C') {
                    Customer customer = (Customer)oit.readObject();
                } else if(id.charAt(0) == 'S') {
                    Seller seller = (Seller)oit.readObject();
                } else {
                    System.out.println("??? 어케 왔누");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    oot.close();
                    bos.close();
                    oot.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }
        return true;
    }

    public void usersList() {

    }
}
