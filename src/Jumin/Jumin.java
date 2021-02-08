package Jumin;

import java.util.Scanner;

public class Jumin {
    static String jumin;
    static char gender;
    public static boolean JuminCheck(String jumin) {
        return (jumin.length() == 14) ? true : false;
    }

    public static boolean GenderNumCheck() {
        gender = jumin.replace("-", "").charAt(6);
        switch (gender) {
        case '1':
        case '2':
        case '3':
        case '4':
            return true;
        default:
            return false;
        }
    }

    public static void GenderPrint(char gender) {
        switch (gender) {
        case '1':
        case '3':
            System.out.println("남자입니다.");
            break;
        case '2':
        case '4':
            System.out.println("여자입니다.");
            break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("주민번호를 입력해주세요 (123456-1234567) > ");
            jumin = scanner.nextLine();
            if ((!JuminCheck(jumin) || !GenderNumCheck())) {
                System.out.println("형식에 맞게 입력해주세요.");
            }
        } while ((!JuminCheck(jumin) || !GenderNumCheck()));
        GenderPrint(gender);
    }
}
