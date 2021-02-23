package Project;

/*소비자는 돈, 포인트를 가지고 있다.
소비자는 주문을 할 수 있다. (메뉴, 수량, 배달 주소 지정 등)
소비자는 매장 정보를 볼 수 있다. (메뉴, 가격, 전화번호 등)
소비자는 주문을 취소할 수 있다.
소비자는 주문 내역을 볼 수 있다.
소비자는 배달 예정 시간을 확인할 수 있다.
소비자는 가게를 즐겨찾기에 추가할 수 있다.*/

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable {
    private String id;
    private int money;
    private int point;
    private String address; // 주소지
    private ArrayList<Seller> bookmark; //매장 넣기.

    public Customer(int money, int point) {
        this.money = money;
        this.point = point;
    }
    //주문
    public void order() {

    }
    //결제하기
    public void pay(){

    }
    //상품목록 읽기(메뉴임 ㅎ)
    public void getShops() {

    }
    //주문취소
    public void noShow() {

    }
    //배달시간 보기
    public void checkTime() {

    }
}
