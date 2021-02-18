

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Type {
	static Scanner scanner;
	static void type(File type) {

		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			
			fr = new FileReader("a.txt");
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
		
		
	}

	public static void main(String[] args) {
		
		if(args.length != 1) {
			System.out.println("사용법 : java [실행할 파일명][경로명] type [경로명]");
			System.out.println("예시 : java EX10_File_Sublist C:\\Temp tyep C:\\Temp\\a.txt");
			System.exit(0);
		}
		File f = new File(args[0]);
		if( !f.exists() || !f.isDirectory()) {
			System.out.println("유효하지 않은 경로");
			System.exit(0);
		}
		
		// 여기까지 내려오면 정상적인 경로고 폴더라는 것이 확인 되었음
		type(f);
		
		

	}

}
