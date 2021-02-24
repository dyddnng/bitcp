package Quiz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Dos {
    public static void main(String[] args) {
    	//"/Users/joohyun/java_test"
    	
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("원하시는 메뉴를 선택해주세요.");
    	System.out.println("1. 새 폴더 생성 2. 파일 읽어오기");
    	int userChoice = scanner.nextInt();
    		
    		switch(userChoice) {
    		case 1: String path = "C:\\Temp\\java_test"; //디렉토리 생성할 경로
    			File dir = new File(path);
            
    			File f = new File(path);
    			if(!f.exists()) {
    				//디렉토리 생성 
    				f.mkdir(); 
    				System.out.println("폴더를 생성합니다.");
    				//정상적으로 폴더 생성 시 true 반환 
    				System.out.println("폴더가 존재하는지 체크 true/false : "+f.exists());
    			} else {
    				System.out.println("이미 해당 폴더가 존재합니다.");
    				System.exit(0); //프로그램 강제 종료 
    			}
    			break;
    		case 2:
    			   FileReader fr = null;
    			   BufferedReader br = null;
    		
    		try {
    			System.out.println("읽어오기를 원하는 파일의 경로를 써주세요. 예) C:\\\\Temp\\\\a.txt");
    			scanner.nextLine();
    			String type = scanner.nextLine();
    			fr = new FileReader(type);
    			br = new BufferedReader(fr);
    			
    			String line = "";
    			
    			for(int i = 0; (line = br.readLine()) != null; i++){
    				System.out.println(line);
    			}
    			
    		} catch (Exception e) {
    			// TODO: handle exception
    		} finally {
    			
    			try {
    				br.close();
    				fr.close();
    			} catch (Exception e2) {
    				// TODO: handle exception
    			}
    			
    		}

    			break;
    	
    	}
    		    	
    	
        
        //scanner.close();
    }
}
