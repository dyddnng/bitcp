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

public class BitEats {
    private HashMap<String, String> users;
    private ArrayList<Seller> sellers;
    // 각 층을 담을 배열

//    ArrayList<HashMap<Integer, Shop>> floors = new ArrayList<HashMap<Integer, Shop>>();
//
//    HashMap<Integer, Shop> floor1 = new HashMap<Integer, Shop>();
//
//        floor1.put(0, new Donkatsu());
//        floor1.put(1, new IceCream());
//        floor1.put(2, new Bread());

    //회원가입
    public void joinUser(String id, String password) {
        users = new HashMap<>();
    }

    //매장목록 불러오기 <I/O>
    public void joinSeller() {

    }

    //매장목록 수정하기 <I/O>

    //

}
