package Dutch;

import java.util.Scanner;

public class DutchPay {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int totalprice = 0;
        int fprice = 0;
        String fname = null;
        int i = 0;
        System.out.println("*****************************");
        System.out.println("*      더치페이 계산 프로그램      *");
        System.out.println("*                           *");
        System.out.println("*   금액을 받아, 인원수만큼 나눔!   *");
        System.out.println("*****************************");
        System.out.println();
        do {
            System.out.println("하실 작업을 입력해주세요");
            System.out.println("1.계산목록추가        2.입력중지");
            i = scanner.nextInt();

            switch (i) {
            case 1:
                System.out.println("음식이름을 적어주세요");
                scanner.nextLine();
                fname = scanner.nextLine();
                System.out.println(fname + "의 가격을 적어주세요");
                fprice = scanner.nextInt();
                totalprice += fprice;
                System.out.println("계산목록에 추가되었습니다.");
                System.out.println("현재 총 가격: " + totalprice);
                break;
            case 2:
                System.out.println("입력을 중지합니다");
                break;
            }
        } while (i != 2);
        if (totalprice != 0) {
            System.out.println("총 인원수를 적어주세요");
            int count = scanner.nextInt();
            System.out.println("각자 내셔야할 금액은 " + totalprice / count + "입니다.");
        } else {
            System.out.println("입력된 값이 없습니다.");
        }

    }

}
