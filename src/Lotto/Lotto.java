package Lotto;

import java.util.Random;
import java.util.Scanner;

public class Lotto {
    private int[] numbers; // 로또 랜덤번호
    private Scanner scanner;
    private Random random;

    public Lotto() { // Lotto 생성자
        numbers = new int[6];
        scanner = new Scanner(System.in);
        random = new Random();
    }

    public void selectLottoNumbers() {
        while (true) {
            //메뉴
            System.out.println("*************************");
            System.out.println("**1. 당첨 예상 번호 추출하기! **");
            System.out.println("**2. 프로그램 종료 ^^7     **");
            System.out.println("*************************");
            System.out.println("원하시는 메뉴 번호를 입력하세요 : ");
            int Menu = scanner.nextInt();

            if (Menu == 1) {
                // 번호 추출, 중복 확인
                for (int i = 0; i < numbers.length; i++) {
                    int number = (int) (Math.random() * 45 + 1);
                    for (int j = 0; j < numbers.length; i++) {
                        if (number == numbers[j]) {
                            number = (int) (Math.random() * 45 + 1);
                            j = -1;
                        }
                        else {
                            numbers[i] = number;
                        }
                    }
                    
                }
                //정렬
                for (int i = 0; i < numbers.length - 1; i++) {
                    if (numbers[i] > numbers[i + 1]) {
                        int temp = numbers[i];
                        numbers[i] = numbers[i + 1];
                        numbers[i + 1] = temp;
                    }
                    i = -1;
                }
                //출력
                System.out.println("[ 선택한 Lotto 번호 ]");
                System.out.printf("[%d][%d][%d][%d][%d][%d]", numbers[0], numbers[1], numbers[2], numbers[3], numbers[4], numbers[5]);
                System.err.println();
            }
            
            //프로그램 종료
            else if (Menu == 2) {
                System.out.println("Good Lucky ^^ ");
                System.exit(0);
            }
            
            else {
                System.out.println("잘못입력하셨습니다.");
            }
        }
        
    }
    
    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        lotto.selectLottoNumbers();
    }
}