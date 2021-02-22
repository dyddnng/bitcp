package Project;

//특이사항 : 매출 6조

/*
생각을 해봤는데 아무래도
BitEats 회사클래스에서 Seller를 등록하게하고
Seller가 메뉴판을 만들어 파일을 만들게 하는 메소드를 만들어야하나?
아닐수도있음.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BitEats {
    //사용자 아이디
    private HashMap<String, String> users;
    //사용자 ID 리스트
    private ArrayList<HashMap<String, String>> usersList;
    //판매자 아이디
    private HashMap<String, String> sellers;
    //로그인 데이터
    private ArrayList<HashMap<String, String>> sellersList;

    private int userMembers ; //등록된 사용자 회원수(나중에 ArrayList 에서 회원꺼낼때 써야할듯..
    // 각 층을 담을 배열
    private int sellerMembers ; //등록된 판매자 회원수

    //회원가입 (사용자)
    public void joinUser() {
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        String password = scanner.nextLine();

        this.users = new HashMap<>();
        this.users.put(id, password);
        usersList.add(users);
        userMembers++;
    }

    //회원가입 (판매자)
    public void joinSeller() {
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        String password = scanner.nextLine();

        this.sellers = new HashMap<>();
        this.sellers.put(id, password);
        sellersList.add(sellers);
        sellerMembers++;
    }

    public void userLogin() {
        Scanner scanner = new Scanner(System.in);

    }


    //매장목록 불러오기 <I/O>
 /*   public void joinSeller() {

    }*/

    //매장목록 수정하기 <I/O>

    //

}
