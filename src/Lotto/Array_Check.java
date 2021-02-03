package day0126;
// 배열 안에서 중복을 찾는 법
// 사용자로부터 입력을 받아서 int[] 안의 값에 넣어주되
// 만약 그 값이 이미 존재하는 경우에는 다시 입력하라고 한다.

import java.util.Scanner;

public class Array_Check {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] intArray = new int[4];
        
        for(int i = 0; i < intArray.length; i++) {
            System.out.print(i+"번째 값: ");
            int userInput = scanner.nextInt();
            
            // 중복인지 체크하는 j for문
            for(int j = 0; j <intArray.length; j++) {
                if(userInput == intArray[j]) {
                    System.out.println("중복된 값입니다.");
                    System.out.print(i+"번째 값: ");
                    userInput = scanner.nextInt();
                    // scanner코드가 실행되고 j를 -1로 초기화 해주어야
                    // 마지막에 j++이 실행됐을 때 j가 다시 0이 되어
                    // 0번째 index 즉 배열의 맨 처음부터 다시 검사하게 할 수 있음
                    j = -1;
                }
                
            }
            intArray[i] = userInput;
        }
        for(int i = 0; i <intArray.length; i++ ) {
            System.out.println(intArray[i]);
        }
 
        scanner.close();
    }

}
