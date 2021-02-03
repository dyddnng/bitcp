package Lotto;

import java.util.Random;
import java.util.Scanner;

class Lotto {
    private int[] numbers; //로또 랜덤번호
    private Scanner scanner;
    private Random random;
    
    public Lotto() { //Lotto 생성자
        numbers = new int[6];
        scanner = new Scanner(System.in);
        random = new Random();
    }
    
    public void LottoNumber() {
        for(int i= 0; i < numbers.length; i++) {
            int number = (int)(Math.random()*45 +1);
        }
    }
    
}