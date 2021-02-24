package Quiz;

import java.util.Scanner;

public class junggusik2 {
	

	static String regExp;
	static Scanner scanner = new Scanner(System.in);
	static final int EXIT = 6;
	
	public static void main(String[] args) throws Exception{
		
		while(true) {
			System.out.println("유효성 식별 프로그램");
			System.out.println(
					"1. e-mail 2. 주민등록번호 3. IP 4. 차량번호 5. 휴대폰번호 6. 종료");
			
			int a = scanner.nextInt();
			
			switch(a) {
			case 1 : email();
			break;
			case 2 : jumin();
			break;
			case 3 : ip();
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
				// e-mail 형식 유효성 검사
	public static void email() {
		
		System.out.println("E-mail 주소를 입력해주세요!");
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
				// 주민번호 형식 유효성 검사	
	public static void jumin() {
		
		System.out.println("주민등록번호를 입력해주세요!");
		String regExp = "^\\d{6}-[1-4]\\d{6}";
		scanner.nextLine();	
		String userInput = scanner.nextLine();
		boolean bo = userInput.matches(regExp);  // true ,false 유효성 검사
		
		if(bo == true) {
			System.out.println("올바른 형식의 주민등록 번호입니다!");
		} else {
			System.out.println("땡! 주민등록번호의 형식은 XXXXXX-XXXXXXX이며 일곱번째 숫자는 1~4사이의 숫자만 허용합니다!");
		}
	}
				// IP 형식 유효성 검사
	public static void ip() {

         System.out.println("아이피를 입력해주세요!");
         String regExp = "^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$";
         String data = scanner.nextLine();
         boolean b = data.matches(regExp); // true ,false 유효성 검사
         if (b == true) {
             System.out.println("올바른 형식의 아이피입니다!");
         } else {
             System.out.println("땡 ! 아이피형식은 123.123.123.123 입니다!");
         }
	}
				// 차량번호 형식 유효성 검사	
	public static void carNumber() {
		
		System.out.println("차량 번호를 입력해주세요!");  
        String regExp =  "^\\d{2}[가|나|다|라|마|거|너|더|러|머|버|서|어|저|고|노|도|로|모|보|소|오|조|구|누|두|루|무|부|수|우|주|바|사|아|자|허|배|호|하WWx20]\\d{4}/*$"; 
        scanner.nextLine();
        String userInput = scanner.nextLine();
        boolean bo = userInput.matches(regExp); // true ,false 유효성 검사
        
        if (bo == true) {
            System.out.println("올바른 형식의 차량번호입니다!");
        } else {
            System.out.println("땡! 차량번호의 형식은 숫자 2자리+한글+숫자 4자리입니다!");
        }
		
       
	}
				// 휴대폰 번호 형식 유효성 검사	
	public static void phoneNumber() {

		System.out.println("휴대전화 번호를 입력해주세요!");
         
        String regExp = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$";
        // 요즘 대부분이 010을 사용하지만 019나 016이 아직 생존하고 있을 가능성을 고려해
        // OR연산자를 사용했습니다
        scanner.nextLine();
        String userInput = scanner.nextLine();
        boolean bo = userInput.matches(regExp);
        if (bo == true) {
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
3. 아이피
"^(\d{1,3})\.(\d{1,3})\.(\d{1,3})\.(\d{1,3})$"
(이스케이프문자 제외 )
^, $ : 문자열 시작, 문자열 종료
\d: 숫자 [0-9], 숫자 0~9 의 범위를 나타냄
{1, 3} : 횟수 또는 범위, 1번 or 3번
() : 소괄호안의 문자를 하나의 문자로 인식
. : 임의의 한 문자
4. 차량번호
 "^\\d{2}[가|나|다|라|마|거|너|더|러|머|버|서|어|저|고|노|도|로|모|보|소|오|조|구|누|두|루|무|부|수|우|주|바|사|아|자|허|배|호|하WWx20]\\d{4}/*$";
^ : 문자열 시작
 \ : 이스케이프 문자
 | : 패턴 안에서 or 연산을 수행할때
 \d : 숫자[]
 {} : 횟수 또는 범위를 나타냄
 * : 없는 또는 1개 이상
 $ : 문자열의 종료
 
6. 휴대폰번호
^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$
^ 문자열 시작, 01 까지는 그냥 출력
() 소괄호 안의 문자를 하나의 문자로 인식
? 앞에는 문자가 없거나 하나
\\d 숫자를 의미함
{} 안에는 숫자들이 들어감. 괄호 안의 숫자가 횟수나 범위를 의미
| OR 연산자. 3자리 숫자 혹은 4자리 숫자를 허용한다는 뜻

 */

