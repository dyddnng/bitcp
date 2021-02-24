package ProjectLSJ0224;

//특이사항 : 매출 6조

/*
생각을 해봤는데 아무래도
BitEats 회사클래스에서 Seller를 등록하게하고
Seller가 메뉴판을 만들어 파일을 만들게 하는 메소드를 만들어야하나?
아닐수도있음.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BitEats {
    //사용자 아이디
    private HashMap<String, String> users;
    //판매자 아이디
    private HashMap<String, String> sellers;

    //회원가입 (구매자, 판매자)
    public void joinUser() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("비트이츠 회원가입 시스템입니다!!");

        System.out.println("가입하실 유형을 입력해주세요! 구매자 / 판매자");
        String type = scanner.nextLine();
        switch (type) {
            case "구매자" :
                System.out.println("구매자를 선택하셨습니다!");
                break;
            case "판매자" :
                System.out.println("판매자를 선택하셨습니다!");
                break;
            default:
                System.out.println("이상한걸 입력하셨네요..");
                return;
        }

        System.out.println("아이디를 입력해주세요");
        String id = scanner.nextLine();
        System.out.println("비밀번호를 입력해주세요");
        String password = scanner.nextLine();

        this.users = new HashMap<>();
        this.users.put(id, password);
        LoginInfo temp = new LoginInfo(type, id, users);
        temp = null; //다음 회원가입을 위해 객체 null화
    }

    public void userLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("비트이츠 로그인 시스템입니다!!");

        System.out.println("로그인하실 유형을 입력해주세요! 구매자 / 판매자");
        String type = scanner.nextLine();
        String path = "";
        switch (type) {
            case "구매자" :
                System.out.println("구매자를 선택하셨습니다!");
                path = "Customers";
                break;
            case "판매자" :
                System.out.println("판매자를 선택하셨습니다!");
                path = "Sellers";
                break;
            default:
                System.out.println("이상한걸 입력하셨네요..");
                return;
        }

        System.out.println("아이디를 입력해주세요");
        String id = scanner.nextLine();
        System.out.println("비밀번호를 입력해주세요");
        String password = scanner.nextLine();

        String filename = "C:\\BitEats\\LoginInfo\\" + path +"\\" +id + ".txt";

        FileInputStream fis = null;
        BufferedInputStream bis = null;
        ObjectInputStream in = null;

        try {
            fis = new FileInputStream(filename); //파일이름불러오고
            bis = new BufferedInputStream(fis); //불러온걸 버퍼로옮기고
            in = new ObjectInputStream(bis); //버퍼로 옮긴걸 조립한다

//            UserInfo r1 = (UserInfo) in.readObject(); //다운캐스팅을 해줘야함

            LoginInfo loginInfo = (LoginInfo) in.readObject();
            HashMap map = loginInfo.getLogin();

            if(map.get(id).equals(password)) { //아이디와 키값이 같다면
                System.out.println("로그인성공 ㅎ");
            } else {
                System.out.println("비밀번호가 틀립니다!!");
            }

        } catch (FileNotFoundException fn) {
            System.out.println("해당 아이디가 존재하지 않습니다");
        } catch (EOFException eofe) {
            System.out.println("파일이 끝났어오");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        } finally {
            try {
                in.close();
                bis.close();
                fis.close();
            } catch (Exception e3) {

            }
        }

    }


    //매장목록 불러오기 <I/O>
 /*   public void joinSeller() {

    }*/

    //매장목록 수정하기 <I/O>

    //

}

