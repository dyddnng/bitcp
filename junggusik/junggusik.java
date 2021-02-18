package Quiz;

import java.util.Scanner;

public class junggusik {
	

	static String regExp;
	static Scanner scanner = new Scanner(System.in);
	static final int EXIT = 6;
	
	public static void main(String[] args) throws Exception{
		
		while(true) {
			
			System.out.println(
					"1. e-mail 2. 주민등록번호 3. 천 단위 Comma 표시 4. 차량번호 6. 종료");
			
			int a = scanner.nextInt();
			
			switch(a) {
			case 1 : email();
			break;
			case 2 : jumin();
			break;
			case 3 : thousands();
			break;
			case 4 : carNumber();
			break;
			case 5 : phoneNumber();
			break;
			case EXIT : System.out.println("시스템을 종료합니다.");
			System.exit(0);
			break;
			}
			
		}
		
	}
	
	public static void email() {
		
		System.out.println("1. E-mail 주소를 입력해주세요!");
        String regExp = "^[a-zA-Z0-9-_\\.]+@[a-zA-Z0-9]+\\.[a-zA-Z]+$";
        scanner.nextLine();
        String userInput = scanner.nextLine();
        boolean bo = userInput.matches(regExp); // true ,false 유효성 검사
        if (bo == true) {
            System.out.println("올바른 형식의 email입니다!");
        } else {
            System.out.println("땡! E-mail 형식은 abcd123@gmail.com 입니다!");
        }
		
	}
	
	public static void jumin() {
		
		System.out.println("2. 주민등록번호를 입력해주세요!");
		String regExp = "^\\d{6}-[1-4]\\d{6}";
		scanner.nextLine();
		
		String userInput = scanner.nextLine();
		boolean bo = userInput.matches(regExp);  // true ,false 유효성 검사
		
		if(bo == true) {
			System.out.println("올바른 형식의 주민등록 번호입니다!");
		} else {
			System.out.println("땡! 주민등록번호의 형식은 XXXXXX-XXXXXXX이며 일곱번째 숫자는 1~4사이의 숫자만 허용합니다.");
		}
	}
	
	public static void thousands() {
		// 명환이 정규표현식이랑 해석 붙일 예정
		System.out.println("3. 천 단위 이상의 숫자를 입력해주세요!");
		String userInput = scanner.nextLine(); // input
        System.out.println("입력: " + userInput);
        String strOuputNum = CommaRegexExam.setComma(userInput);
        System.out.println("변환결과 : " + strOuputNum); // output
	}
	
	public static void carNumber() {
		
		// 정규표현식 수정하고 해석 덧붙여야함
		System.out.println("4. 차량 번호를 입력해주세요!");  
        //String regex = "^\\d{2}[가|나|다x3]\\d{4}/*$"; 
        scanner.nextLine();
        String userInput = scanner.nextLine();
        boolean bo = userInput.matches(regExp); // true ,false 유효성 검사
        
        if (bo == true) {
            System.out.println("올바른 형식의 차량번호입니다!");
        } else {// 숫자 2 + 한글 +숫자3로 이루어진
            System.out.println("땡! 차량번호의 형식은 숫자 2자리+한글+숫자 3자리입니다!");
        }
		
       
	}
	
	public static void phoneNumber() {
		// 승준 해석 덧붙일 예정
		System.out.println("휴대전화 번호를 입력해주세요!");
         
        String regExp = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$";
        String userInput = scanner.nextLine();
        boolean b2 = userInput.matches(regExp);
        if (b2 == true) {
            System.out.println("올바른 휴대전화 번호입니다!");
        } else {
            System.out.println("땡! 휴대전화 번호 형식은 ex 010-1234-5678 입니다!");
        }
    }
		
	
}

//해석 코드와는 따로 올릴 것
/*
1. email 해석
 ^[a-zA-Z0-9-_\\.]+@[a-zA-Z0-9]+\\.[a-zA-Z]+$

  ^ : 문자열의 시작 
  [] : 문자클래스 선언 
  a-zA-Z : ASCII 코드상 a 와 z 사이, A 와 Z 사이 문자
  0-9 : 0과 9사이 숫자 
  -_ \\. : 특수문자 - _ . 허용
  + : 위 문자셋 중 최소 한가지 이상 값이 나와야 함
  @ : 이메일 형식에 @ 필수 
  \\. : 이메일 형식에 . 필수
  $ : 문자열의 종료
  
2. 주민등록번호 해석

^\\d{6}-[1-4]\\d{6}

^ : 문자열의 시작
 \ : 뒤에 오는 특수문자를 특수문자 그대로 받아들이라는 의미 \\d는 \d를 인식하라는 뜻
\d : 숫자 0~9와 동일
 {} : 횟수나 범위 즉 \d{6}은 0~9사이의 숫자 여섯자리를 허용한다는 뜻
 [] : 괄호 안에 정해진 문자형식의 범위 바 뒤에 첫 숫자는 1~4 사이 숫자만 허용한다는 뜻

3. 숫자


4. 차량번호



6. 휴대폰번호
^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$


 */



