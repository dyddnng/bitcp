package Project;

/*소비자는 돈, 포인트를 가지고 있다.
소비자는 주문을 할 수 있다. (메뉴, 수량, 배달 주소 지정 등)
소비자는 매장 정보를 볼 수 있다. (메뉴, 가격, 전화번호 등)
소비자는 주문을 취소할 수 있다.
소비자는 주문 내역을 볼 수 있다.
소비자는 배달 예정 시간을 확인할 수 있다.
소비자는 가게를 즐겨찾기에 추가할 수 있다.*/

import java.util.ArrayList;

public class User {
    private int money;
    private int point;
    private ArrayList<Seller> bookmark;

    public User(int money, int point) {
        this.money = money;
        this.point = point;
        this.bookmark = new ArrayList<>();
    }
    //주문
    public void order() {

    }
    //상품목록 읽기
    public void getShops() {

    }
    //주문취소
    public void noShow() {

    }
    //즐겨찾기 추가
    public void addBookmark() {

    }
    //즐겨찾기 보기
    public void readBookmark() {

    }
}
