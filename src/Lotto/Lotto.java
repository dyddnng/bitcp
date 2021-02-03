package Lotto;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
    private int[] numbers; // 로또 랜덤번호
    private Scanner scanner;
    private Random random;
    private int sum;

    public Lotto() { // Lotto 생성자
        this.numbers = new int[6];
        this.scanner = new Scanner(System.in);
        this.random = new Random();
        this.sum = 0;
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

            //랜덤으로 뽑은 로또
            if(Menu == 1) {
                this.sum = 0;
                for (int i = 0 ; i < numbers.length; i++) {
                    int randNumber = random.nextInt(45) + 1;
                    //중복확인 코드        
                    for (int j = 0; j < numbers.length; j++) {
                        if (randNumber == numbers[j]) {
                            randNumber = random.nextInt(45) + 1 ;
                            j = - 1; //j값을 -1로 만들어서 다시 for문을 순회하게끔 만들어줌
                            }                    
                        }
                    numbers[i] = randNumber;
                    sum += randNumber;
                    }
                    Arrays.sort(numbers);
                    //출력
                    System.out.printf("평균 : [%d]\n", sum / numbers.length );
                    System.out.println("[ 선택한 Lotto 번호 ]");
                    System.out.printf("[%d][%d][%d][%d][%d][%d]\n", numbers[0], numbers[1], numbers[2], numbers[3], numbers[4], numbers[5]);
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
}