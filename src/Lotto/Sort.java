package Lotto;
// 정렬
// 값에 따라서 오름차순 혹은 내림차순으로 배열 안의 값들을 정리해주는 것
// 오름차순: index가 작을 수록 값도 작음 1 2 3 4 5....
// 내림차순: index가 작을 수록 값은 큼 6 5 4 3 2 1

//직접 정렬을 만들어보자

public class Sort {
	public static void main(String[] args) {
		int[] intArray = {3, 1, 9, 4, 8, 2};
		
		for(int i = 0; i < intArray.length; i++) {
			System.out.printf("intArray [%d]: %d\n", i, intArray[i]);
		}
		
		// 우리가 구현할 정렬 방법은
		// index와 그 다음 index의 값을 비교해서
		// 만약 다음 index가 더 작으면
		// 두 개의 위치를 바꿔주고 처음부터 다시 검사하는 형식으로 진행된다.
		
		// 아래의 조건에서 i < intArray.length 라고 할 경우
		// i가 0일 때부터 index를 순서대로 두 개씩 묶어서 비교하기 때문에
		// i = intArray.length가 되면 배열의 범위를 벗어나 에러가 난다
		// 그러므로 i < intArray.length-1 로 조건을 설정해야 한다.
		for(int i =0; i < intArray.length - 1; i++) {
			// 그리고 for문 중괄호 안의 코드가 모두 실행되면
			// i++이 실행된다
			
			// 아래 if 조건식은 이런 뜻이다
			// intArray의 i번째 index가 그 다음 index(즉 intArray[i+1]) 보다 클 경우
			if( intArray[i] > intArray[i+1]) {
				System.out.println(i+"번째가 "+(i+1)+"번째보다 크므로 바꾼다.");
				
				// 프로그래밍에서 무언가를 바꾸려면 반드시 이전 것을 빼서 이동할 빈 공간이 하나 필요하다
				// 마치 전구를 하나 갈려면 세 칸이 필요한 것처럼
				// 헌 전구 한 칸, 빈 공간 한 칸, 새 전구 한 칸
				// 즉 두 index의 순서를 바꾸겠다고 바로
				// intArray[i] = intArray[i+1]로 초기화하고
				// intArray[i+1] = intArray[i]로 초기화했다간
				// intArray[i]의 값이 intArray[i+1]의 값을 복사해 같아지고
				// 이전의 intArray[i]값이 아니라 intArray[i+1]과 같아진 값이
				// 다시 intArray[i+1]로 초기화되는 것
				// 그래서 int a와 int b의 순서를 바꿔주려면 그 둘의 값이 복사되지 않도록
				// 임시로 보존할 일종의 임시 변수 temp가 필요하다
				// 칸 세 개에서 공 두 개를 돌리는 거라고 생각하면 됨
				
				int temp = intArray[i];
				intArray[i] = intArray[i+1];
				intArray[i+1] = temp;
				
				// 두 index의 순서를 바꿔주는 for문의 중괄호가 실행되고 나면 i++이 실행되는데
				// 우리는 다시 처음부터 index의 크기를 비교해야 하기 때문에
				// i++의 결과가 i=0이 되도록 아래와 같이 입력해야 한다.
				i = -1;
				
				System.out.printf("%d %d %d %d %d %d\n", 
						intArray[0], intArray[1], intArray[2],
						intArray[3], intArray[4], intArray[5]);
				
			}
			
		}
	}

}

// 숙제
// 가위바위보 게임을 만드세요
// 가위 : int 1
// 바위 : int 2
// 보 : int 3

// 예시:
// 가위바위보 중 하나를 선택해주세요(가위 : 1 바위 : 2 보 : 3)
// > 5
// 잘못입력하셨습니다.
// 가위바위보 중 하나를 선택해주세요(가위 : 1 바위 : 2 보 : 3)
// > 2
// 사용자 : 바위
// 컴퓨터 : 가위
// 사용자 승!!
// 현재 전적: 1승 3무 2패
// 1. 플레이 2. 현재 전적 보기 3. 종료
// >2
// 현재 전적은 1승 3무 2패입니다. 승률은 16.6667퍼센트입니다.
// 1. 플레이 2. 현재 전적 보기 3. 종료
// 사용해주셔서 감사합니다.

