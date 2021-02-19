  
package Lotto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Lotto_Up {
    private List<String> LottoNums;
    private FileReader fr;
    private BufferedReader br;
    private FileWriter fw;
    private BufferedWriter bw;
    private String LottoDate;
    
    
    public Lotto_Up() {
        LottoNums = new ArrayList<String>();
        
        Date date = new Date();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy년.MM월.dd일.HH시.mm분");
        LottoDate = dateformat.format(date);
    }
    
    public void addLotto() {
        Set<Integer> LottoNum = new TreeSet<Integer>();
        String Lotto = "로또 " + (LottoNums.size()+1) + "회차: ";
        for(int i=0;LottoNum.size()<6;i++) {
            LottoNum.add((int)(Math.random() * 45 + 1));
        }
        Lotto += LottoNum.toString() + " [" + LottoDate + "]";
        LottoNums.add(Lotto+"\n");
        System.out.printf("%s\n",Lotto);
    }
    
    public void writeLotto() {
        try {
            fw = new FileWriter("Lotto.txt",false);
            bw = new BufferedWriter(fw);
            for(int i=0;i<LottoNums.size();i++) {
                bw.write(LottoNums.get(i));
            }
            
        } catch (Exception e) {
            
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
    
    public void ReadLotto() {
        try {
            fr = new FileReader("Lotto.txt");
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
    
    public static void main(String[] args) {
        Lotto_Up lotto = new Lotto_Up();
        
        lotto.addLotto();
        lotto.addLotto();
        lotto.addLotto();
        lotto.addLotto();
        lotto.addLotto();
       
        lotto.writeLotto();
        System.out.println("-------------------------------ReadLotto-------------------------------");
        lotto.ReadLotto();
    }
}