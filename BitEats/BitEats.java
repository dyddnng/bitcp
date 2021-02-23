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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BitEats {

    private Map<String, String> users;
    private List<Order> ordersList;
    private Scanner scanner;
    private FileOutputStream fos;
    private BufferedOutputStream bos;
    private ObjectOutputStream oot;
    private FileInputStream fis;
    private BufferedInputStream bis;
    private ObjectInputStream ois;
    private final String USERINFO = "C:\\Temp";
    Seller seller;
    Customer customer;

    public BitEats() {
        users = new HashMap<String, String>();
        ordersList = new ArrayList<Order>();
        scanner = new Scanner(System.in);
    }

    public boolean join() {
        System.out.println("가입자 유형을 입력해주세요 (소비자:\'1\', 판매자:\'2\')");
        System.out.print("> ");
        int type = scanner.nextInt();

        System.out.println("가입할 아이디를 입력해주세요 (소문자)");
        System.out.print("> ");
        scanner.nextLine();
        String id = scanner.nextLine();

        System.out.println("가입할 비밀번호를 입력해주세요");
        System.out.print("> ");
        String pwd = scanner.nextLine().trim();

        if (users.containsKey(id) || users.containsValue(pwd)) {
            System.out.println("이미 존재하는 아이디거나 비밀번호입니다.");
            return false;
        }

        if (!(type == 1 || type == 2)) {
            System.out.println("사용자 유형을 잘못입력하셨습니다.");
            return false;
        } else if (type == 1) {
            try {
                fos = new FileOutputStream("userInfo.txt", true);
                bos = new BufferedOutputStream(fos);
                oot = new ObjectOutputStream(bos);// 직렬화 끝

                id = "C" + id;

                // 직렬화 대상
                oot.writeObject(new Customer(id, "bit시 bit동"));
                System.out.println(id);
                System.out.println(pwd);
                users.put(id, pwd);

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
                fos = new FileOutputStream("userInfo.txt", true);
                bos = new BufferedOutputStream(fos);
                oot = new ObjectOutputStream(bos);// 직렬화 끝

                id = "S" + id;

                // 직렬화 대상
                oot.writeObject(new Seller(id));
                System.out.println(id);
                System.out.println(pwd);
                users.put(id, pwd);

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
        System.out.println("소비자일 경우 \'C\', 판매자일 경우 \'S\' 가 아이디 맨 앞에 자동으로 붙었습니다.");
        System.out.print("> ");
        String id = scanner.nextLine();

        System.out.println("비밀번호를 입력해주세요");
        System.out.print("> ");
        String pwd = scanner.nextLine().trim();

        if (!(users.containsKey(id))) {
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
                fis = new FileInputStream("userInfo.txt");// C:\\BitEats\\User\\Customer\\id.txt
                bis = new BufferedInputStream(fis);
                ois = new ObjectInputStream(bis);

                if (id.charAt(0) == 'C') {
                    this.customer = (Customer) ois.readObject();
                } else if (id.charAt(0) == 'S') {
                    this.seller = (Seller) ois.readObject();
                    System.out.println("중간점검");
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
        Set set = users.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
