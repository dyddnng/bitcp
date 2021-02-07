package Movie;

import java.util.Scanner;

import Person.Person;

public class Movie {

    private final int WIDTH;
    private final int HEIGHT;
    private Scanner scanner;
    private Person[] person;
    private String[][] seat;

    private int menuChoice;
    private int ticketNum;
    private int width;
    private int height;
    private int count;
    private int save;

    {
        WIDTH = 5;
        HEIGHT = 4;
        person = new Person[WIDTH * HEIGHT];
        scanner = new Scanner(System.in);
        count = 0;

        seat = new String[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                seat[i][j] = (i + 1) + "-" + (j + 1);
            }
        }
    }

    // 메인 화면 출력
    private void menu() {
        System.out.println("*********************************************");
        System.out.println("************      영화예매 시스템      ************");
        System.out.println();
        System.out.println(" 1. 예매하기     2. 예매조회     3. 예매취소     4. 종료");
        System.out.println("*********************************************");
        System.out.print(" > ");
        menuChoice = scanner.nextInt();
    }

    // 예매하기
    private void Ticketing() {
        // 좌석 정보 출력
        System.out.println("************좌석 현황************");
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) {
                System.out.printf(" [%s]", seat[i][j]);
            }
            System.out.println();
        }
        System.out.println("********************************");

        // 좌석 선택
        System.out.println("좌석을 선택해주세요! 예시) 2-4 ");
        System.out.println("이미 예매된 좌석은 \"예매\" 라고 표시됩니다.");
        System.out.print(" > ");
        scanner.nextLine();
        String seatChoice = scanner.nextLine();

        
  
        // 입력값을 - 로 나누고, 나눈 값을 int에 저장
        String[] Array = seatChoice.split("-");
        height = Integer.parseInt(Array[0]);
        width = Integer.parseInt(Array[1]);
               
        // 입력된 값이 좌석의 행과 열의 최대치를 벗어난 경우 경고
        if(height > seat.length || width > seat[height].length) {
           System.out.println("존재하지 않는 좌석입니다! 다시 선택해주세요!");
           System.out.print(" > ");
            scanner.nextLine();
            seatChoice = scanner.nextLine();
        }


        // 비어있는 좌석이면, 예매 , 예약되어있는 좌석이면 다른 좌석 선택
        if (!seat[height - 1][width - 1].equals("예매")) {
            System.out.println("비어있는 좌석입니다.");
            System.out.println("예매가능합니다. 예매하시겠습니까?");
            System.out.println(" 네! (1)     아니오 (2)     처음화면(3)");
            System.out.print(" > ");
            int ticketingChoice = scanner.nextInt();

            switch (ticketingChoice) {
            case 0:
                System.out.println("처음화면으로 돌아갑니다.");
                break;
            case 1:
                System.out.println("예매되었습니다. 감사합니다");
                seat[height - 1][width - 1] = "예매";
                ticketNum = (int) ((Math.random() * 9999999) * 10);
                person[count] = new Person(height, width, ticketNum);
                count++;
                System.out.printf("예매한 좌석번호 : [%d-%d]  /  예매번호 : %d\n", height, width, ticketNum);

                break;
            case 2:
                System.out.println("예매를 취소하셨습니다.");
                break;
            case 3:
                System.out.println("처음화면으로 돌아갑니다.");
                break;
            default:
                System.out.println("잘못입력하셨습니다.");
            }

        } else {
            System.out.println("이미 예매되어있는 좌석입니다.");
        }
    }

    // 예매조회
    private void TicketCheck() {
        if (ticketNum == 0) {
            System.out.println("예매하신 기록이 없습니다.");
        } else {
            System.out.println("예매번호를 입력해주세요.");
            int ticketNumCheck = scanner.nextInt();

            for (int i = 0; i < person.length; i++) {
                if (person[i].getTicketNumber() == ticketNumCheck) {
                    person[i].printSeatInfo();
                    save = i;
                    break;
                } else if (i == person.length - 1) {
                    System.out.println("예매번호가 틀립니다.");
                }
            }
        }

    }

    // 예매취소
    private void TicketCancel() {
        TicketCheck();
        System.out.println("예매를 취소하시겠습니까?");
        System.out.println(" 네! (1)     아니오 (2)     ");
        System.out.print(" > ");
        int ticketCancelChoice = scanner.nextInt();

        switch (ticketCancelChoice) {
        case 1:
            System.out.println("예매가 취소되었습니다. 감사합니다.");
            seat[person[save].getHeight()-1][person[save].getWidth()-1] = (person[save].getHeight()) + "-" + (person[save].getWidth());
            break;
        case 2:
            System.out.println("예매취소가 취소되었습니다.");
            break;
        default:
            System.out.println("잘못입력하셨습니다.");
        }
    }
    
    private void End() {
        System.out.println("시스템을 종료합니다. 감사합니다.");
        System.exit(0);
    }

    public void startTicketing() {
        while (true) {
            menu();
            switch (menuChoice) {
            case 1:
                Ticketing();
                break;
            case 2:
                TicketCheck();
                break;
            case 3:
                TicketCancel();
                break;
            case 4:
                End();
                break;
            default:
                System.out.println("잘못입력하셨습니다");
            }
        }
    }

    public static void main(String[] args) {
        Movie movie = new Movie();

        movie.startTicketing();
    }
}