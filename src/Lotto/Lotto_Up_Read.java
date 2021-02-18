package Quiz;

import java.io.BufferedReader;
import java.io.FileReader;

public class Lotto_Up_Read {

	public static void main(String[] args) {
	    
	    
	    FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader("Lotto_Up.java");
			br = new BufferedReader(fr);
			
			String line = "";
			for(int i = 0; (line = br.readLine()) != null; i++) {
				System.out.println(line);

				}
			
		} catch (Exception e) {
		} finally {
			
			try {
				br.close();
				fr.close();
				
			} catch (Exception e2) {
			}
		}
		
	}
}
